package br.com.belaAgenda.infra.resourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;


public class ResourceBundleFactory {
    
	public static ResourceBundle createBundle(Class<?> clazz) {
		
	   return ResourceBundle.getBundle(
			   clazz.getName().replace(clazz.getSimpleName(), ""), getLocale());
	 }
	
	private static Locale getLocale(){
		return FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	}

}
