package br.com.belaAgenda.infra.base.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import br.com.belaAgenda.infra.resourceBundle.MessageProvider;
import br.com.belaAgenda.infra.resourceBundle.MessageProviderImpl;

@MappedSuperclass
public class EntityBase implements Cloneable, Serializable{
	
	private static final long serialVersionUID = -261910485446859996L;
	@Transient
	protected MessageProvider messageProvider = new MessageProviderImpl();
	
	public String getMessage(String key){
		return messageProvider.getValue(key);
	}
	
	public Object clone(){
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new RuntimeException("erro na clonagem chechar essa exception mais tarde");
		}
	}
}
