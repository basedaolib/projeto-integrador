package br.com.belaAgenda.infra.resourceBundle;

import java.util.ResourceBundle;

public interface MessageProvider {
	public ResourceBundle getBundle(String name);
	public String getValue(String key);
}
