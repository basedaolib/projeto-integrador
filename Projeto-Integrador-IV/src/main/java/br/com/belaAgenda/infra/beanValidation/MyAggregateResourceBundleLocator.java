package br.com.belaAgenda.infra.beanValidation;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.hibernate.validator.internal.util.Contracts;
import org.hibernate.validator.resourceloading.DelegatingResourceBundleLocator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.hibernate.validator.spi.resourceloading.ResourceBundleLocator;

public class MyAggregateResourceBundleLocator extends DelegatingResourceBundleLocator {
	private final static String BUNDLE_FROM_DELEGATE = "bundleFromDelegate";
	private final List<String> bundleNames;
	private final ClassLoader classLoader;

	public MyAggregateResourceBundleLocator(List<String> bundleNames) {
		this( bundleNames, null );
	}

	public MyAggregateResourceBundleLocator(List<String> bundleNames, ResourceBundleLocator delegate) {
		this( bundleNames, delegate, null );
	}

	public MyAggregateResourceBundleLocator(List<String> bundleNames, ResourceBundleLocator delegate,
			ClassLoader classLoader) {
		super( delegate );
		Contracts.assertValueNotNull( bundleNames, "bundleNames" );

		this.bundleNames = Collections.unmodifiableList( bundleNames );
		this.classLoader = classLoader;
	}

	@Override
	public ResourceBundle getResourceBundle(Locale locale) {
		Map<String, ResourceBundle> sourceBundles = new HashMap<String, ResourceBundle>();

		String bundleFileName;
		for ( String bundleName : bundleNames ) {
			ResourceBundleLocator resourceBundleLocator =
					new PlatformResourceBundleLocator( bundleName, classLoader );

			ResourceBundle resourceBundle = resourceBundleLocator.getResourceBundle( locale );

			if ( resourceBundle != null ) {
				bundleFileName = bundleName.substring(bundleName.lastIndexOf(".") + 1);
				sourceBundles.put(bundleFileName, resourceBundle );
			}
		}

		ResourceBundle bundleFromDelegate = super.getResourceBundle( locale );

		if ( bundleFromDelegate != null ) {
			sourceBundles.put(BUNDLE_FROM_DELEGATE, bundleFromDelegate );
		}

		return sourceBundles.isEmpty() ? null : new AggregateBundle( sourceBundles );
	}

	public static class AggregateBundle extends ResourceBundle {
		private final Map<String, Object> contents = new HashMap<String, Object>();

		public AggregateBundle(Map<String, ResourceBundle> bundles) {
			if ( bundles != null ) {
				ResourceBundle bundle;
				Set<String> bundleKeys = bundles.keySet();
				for ( String bundleKey : bundleKeys ) {
					bundle = bundles.get(bundleKey);
					Enumeration<String> keys = bundle.getKeys();
					while ( keys.hasMoreElements() ) {
						String oneKey = keys.nextElement();
						if ( !contents.containsKey( oneKey ) ) {
							if(!bundleKey.equals(BUNDLE_FROM_DELEGATE)){
								contents.put( bundleKey + "." + oneKey, bundle.getObject( oneKey ) );
							}else{
								contents.put( oneKey, bundle.getObject( oneKey ) );
							}
						}
					}
				}
			}
		}

		@Override
		public Enumeration<String> getKeys() {
			return new IteratorEnumeration<String>( contents.keySet().iterator() );
		}

		@Override
		protected Object handleGetObject(String key) {
			return contents.get( key );
		}
	}

	private static class IteratorEnumeration<T> implements Enumeration<T> {

		private final Iterator<T> source;

		/**
		 * Creates a new IterationEnumeration.
		 *
		 * @param source The source iterator. Must not be null.
		 */
		public IteratorEnumeration(Iterator<T> source) {

			if ( source == null ) {
				throw new IllegalArgumentException( "Source must not be null" );
			}

			this.source = source;
		}

		@Override
		public boolean hasMoreElements() {
			return source.hasNext();
		}

		@Override
		public T nextElement() {
			return source.next();
		}
	}
}

