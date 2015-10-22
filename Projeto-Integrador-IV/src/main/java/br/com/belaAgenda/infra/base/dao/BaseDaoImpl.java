package br.com.belaAgenda.infra.base.dao;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.baseDAOLib.DAO.BaseDAOImpl;
import br.com.belaAgenda.infra.base.model.EntityId;
import br.com.belaAgenda.infra.base.model.type.EstadoEntidade;
import br.com.belaAgenda.infra.resourceBundle.MessageProvider;

public class BaseDaoImpl<T extends EntityId> extends BaseDAOImpl<T> implements BaseDao<T>, Serializable{

	private static final long serialVersionUID = -3066284710854840911L;
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
	
	@Override
	public T insert(T entity) {
		entity.setEstado(EstadoEntidade.Ativo);
		return super.insert(entity);
	}
	
	@Override
	public T update(T entity) {
		entity.setEstado(EstadoEntidade.Ativo);
		return super.update(entity);
	}
	
	protected T beforeSave(T entity){
		return entity;
	}
	protected T afterSave(T entity){ 
		return entity;
	}
	
	public T inativar(T entity){
		entity = antesInativar(entity);
		entity.setEstado(EstadoEntidade.Inativo);
		entity = getEntityManager().merge(entity);
		entity = depoisInativar(entity);
		return entity;
	}
	
	protected T  antesInativar(T entity){
		return entity;
	}
	protected T  depoisInativar(T entity){ 
		return entity;
	}
}
