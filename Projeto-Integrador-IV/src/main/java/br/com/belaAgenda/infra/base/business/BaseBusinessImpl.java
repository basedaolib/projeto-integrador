package br.com.belaAgenda.infra.base.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.belaAgenda.infra.base.dao.BaseDao;
import br.com.belaAgenda.infra.base.model.EntityId;
import br.com.belaAgenda.infra.resourceBundle.MessageProvider;
import br.com.generic.dao.WhereBuilder;
import br.com.generic.dao.WhereEntityBuilder;
import br.com.generic.dao.WhereEntityListBuilder;
import br.com.generic.dao.WhereListBuilder;

@SuppressWarnings("rawtypes")
public abstract class BaseBusinessImpl<T extends EntityId, D extends BaseDao> implements BaseBusiness<T>, Serializable{

	private static final long serialVersionUID = -8429004020315675875L;

	@Inject
	protected D dao;
	
	@Inject
	protected MessageProvider messageProvider;
	
	public String getMessage(String key){
		return messageProvider.getValue(key);
	}
	
	@SuppressWarnings("unchecked")
	public T insert(T entity) {
		return (T) dao.insert(entity);
	}

	@SuppressWarnings("unchecked")
	public T delete(T entity) {
		return (T) dao.delete(entity);
	}

	@SuppressWarnings("unchecked")
	public T update(T entity) {
		return (T) dao.update(entity);
	}
	
	@SuppressWarnings("unchecked")
	public T save(T entity){
		return (T) dao.save(entity);
	}
	
	@SuppressWarnings("unchecked")
	public T inativar(T entity) {
		return (T) dao.inativar(entity);
	}

	@SuppressWarnings("unchecked")
	public T disassociate(T entity) {
		return (T) dao.disassociate(entity);
	}

	@SuppressWarnings("unchecked")
	public T findEntityById(long id) {
		return (T) dao.findEntityById(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list(int beginning, int end, String order){
		return dao.list(beginning, end, order);
	}

	@Override
	@SuppressWarnings("unchecked")
	public WhereEntityListBuilder<T> listEntities() {
		return dao.listEntities();
	}

	@Override
	@SuppressWarnings("unchecked")
	public WhereEntityBuilder<T> searchEntity() {
		return dao.searchEntity();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <E> WhereListBuilder<T, E> listProperties(String field) {
		return dao.listProperties(field);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <E> WhereBuilder<T, E> searchProperty(String field) {
		return dao.searchProperty(field);
	}

	
}
