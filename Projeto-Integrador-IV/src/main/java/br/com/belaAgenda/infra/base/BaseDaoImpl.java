package br.com.belaAgenda.infra.base;

import java.util.ResourceBundle;

import br.com.baseDAOLib.DAO.BaseDAOImpl;
import br.com.belaAgenda.infra.resourceBundle.ResourceBundleFactory;

public class BaseDaoImpl<T> extends BaseDAOImpl<T> {

	private ResourceBundle resourceBundle = ResourceBundleFactory.createBundle(getClass());
	
	public String getMessage(String key){
		return resourceBundle.getString(key);
	}
}
