package br.com.belaAgenda.infra.beanValidation;


import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.spi.resourceloading.ResourceBundleLocator;

import br.com.belaAgenda.infra.resourceBundle.ResourceBundleMessageScan;


public class MyResourceBundleMessageInterpolator extends ResourceBundleMessageInterpolator{
	
	
	
	public MyResourceBundleMessageInterpolator() {
		this(new  MyAggregateResourceBundleLocator( ResourceBundleMessageScan.listarArquivos()));
		
	}
	
	public MyResourceBundleMessageInterpolator(ResourceBundleLocator defaultResourceBundleLocator) {
		this(defaultResourceBundleLocator, true);
	}


	public MyResourceBundleMessageInterpolator(ResourceBundleLocator testResourceBundleLocator, boolean cachingEnabled) {
		super(testResourceBundleLocator, cachingEnabled);
	}

	
	
	
}