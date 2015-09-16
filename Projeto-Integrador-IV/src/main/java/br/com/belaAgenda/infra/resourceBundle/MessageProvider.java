package br.com.belaAgenda.infra.resourceBundle;

import java.io.Serializable;
import java.util.ResourceBundle;

public interface MessageProvider extends Serializable{
	public ResourceBundle getBundle(String name);
	public String getValue(String key);
}
