package br.com.belaAgenda.infra.resourceBundle;

import java.util.Locale;

import javax.enterprise.context.RequestScoped;

import br.com.belaAgenda.infra.resourceBundle.annotation.ResourceBundleAnnotation;

@RequestScoped
public class ResourceBundle<T>{
	
	private java.util.ResourceBundle bundle;
	private Locale locale = LocaleSafe.getLocale();

	
	public ResourceBundle(Class<T> classe,Locale locale) {
		super();
		this.locale = locale;
		setClassBundle(classe);
	}

	public ResourceBundle(Class<T> classe){
		setClassBundle(classe);
	}
	
	public void setClassBundle(Class<T> classe){
		String res = null;
		if(classe.isAnnotationPresent(ResourceBundleAnnotation.class)){
			ResourceBundleAnnotation bundle = classe.getAnnotation(ResourceBundleAnnotation.class);
			
			res = bundle.bundle();
			res += "." + bundle.name();
			
		}else{
			
			bundle = java.util.ResourceBundle.getBundle("br.com.hotstar.resource.util.resourceBundle.message", locale);
			throw new ResourceBundleException(bundle.getString("msgAnotacao") + classe.getName());
			
		}
		
		bundle = java.util.ResourceBundle.getBundle(res, locale);
	}
	
	public String getString(String key){
		return bundle.getString(key);
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	

}
