package br.com.belaAgenda.infra.resourceBundle;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
public class MessageProviderImpl implements MessageProvider{
	 
	private static final long serialVersionUID = -852715624365556741L;

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
        } catch (Exception e) {
            result = "???" + key + "??? not found";
        }
        return result;
    }
}
