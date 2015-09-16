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
	
	@Override
	public T insert(T entity) {
		if(!getEntityManager().getTransaction().isActive()){
			getEntityManager().getTransaction().begin();
		}
		return super.insert(entity);
	}
	
	@Override
	public T update(T entity) {
		if(!getEntityManager().getTransaction().isActive()){
			getEntityManager().getTransaction().begin();
		}
		return super.update(entity);
	}
	
	@Override
	public T delete(T entity) {
		if(!getEntityManager().getTransaction().isActive()){
			getEntityManager().getTransaction().begin();
		}
		return super.delete(entity);
	}
	
	public T save(T entity){
		if(!getEntityManager().getTransaction().isActive()){
			getEntityManager().getTransaction().begin();
		}
		entity = beforeSave(entity);
		if(entity.getId() == 0){
			entity = insert(entity);
		}else{
			entity = update(entity);
		}
		entity = afterSave(entity);
		return entity;
	}
	
	protected T beforeSave(T entity){ return entity;}
	protected T afterSave(T entity){ return entity;}
}
