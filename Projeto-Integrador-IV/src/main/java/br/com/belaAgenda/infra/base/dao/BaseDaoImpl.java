package br.com.belaAgenda.infra.base.dao;

import javax.inject.Inject;

import br.com.baseDAOLib.DAO.BaseDAOImpl;
import br.com.belaAgenda.infra.base.model.EntityId;
import br.com.belaAgenda.infra.resourceBundle.MessageProvider;

public class BaseDaoImpl<T extends EntityId> extends BaseDAOImpl<T> {

	@Inject
	protected MessageProvider messageProvider;
	
	public String getMessage(String key){
		return messageProvider.getValue(key);
	}
	
	public T save(T entity){
		entity = beforeSave(entity);
		if(entity.getId() == 0){
			entity = insert(entity);
		}else{
			entity = update(entity);
		}
		entity = afterSave(entity);
		return entity;
	}
	
	protected T beforeSave(T entity){
		return entity;
	}
	protected T afterSave(T entity){ 
		return entity;
	}
}
