package br.com.belaAgenda.infra.resourceBundle;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class MessageProviderImpl implements MessageProvider{
	 
    public ResourceBundle getBundle(String name) {
    	FacesContext context = FacesContext.getCurrentInstance();
    	ResourceBundle bundle = context.getApplication().getResourceBundle(context, name);
        return bundle;
    }
 
    public String getValue(String key) {
 
        String result = null;
        String name = null;
        String message = null;
        try {
        	name = key.substring(0 , key.indexOf("."));
        	message = key.substring(1 + key.indexOf("."));
            result = getBundle(name).getString(message);
        } catch (MissingResourceException e) {
            result = "???" + key + "??? not found";
        }
        return result;
    }
}
