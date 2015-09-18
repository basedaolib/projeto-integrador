package br.com.belaAgenda.infra.base.business;

import java.util.List;

import javax.inject.Inject;

import br.com.belaAgenda.infra.base.dao.BaseDao;
import br.com.belaAgenda.infra.base.model.EntityId;
import br.com.belaAgenda.infra.resourceBundle.MessageProvider;

@SuppressWarnings("rawtypes")
public abstract class BaseBusinessImpl<T extends EntityId, D extends BaseDao> implements BaseBusiness<T>{
	
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
	public T findEntityForId(long id) {
		return (T) dao.findEntityForId(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list(int beginning, int end, String order){
		return dao.list(beginning, end, order);
	}

	@SuppressWarnings("unchecked")
	public List<T> findEntitiesForProperties(int beginning, int end, String order, String names, Object... values) {
		return dao.findEntitiesForProperties(beginning, end, order, names, values);
	}

	@SuppressWarnings("unchecked")
	public T findEntityForProperties(String names, Object... values) {
		return (T) dao.findEntityForProperties(names, values);
	}

	@SuppressWarnings("unchecked")
	public <E> List<E> findFieldsForProperties(int beginning, int end, String order, String field, String names,
			Object... values) {
		return dao.findFieldsForProperties(beginning, end, order, field, names, values);
	}

	@SuppressWarnings("unchecked")
	public <E> E findFieldForProperties(String field, String names, Object... values) {
		return (E) dao.findFieldForProperties(field, names, values);
	}
}
