package br.com.belaAgenda.infra.base;

import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;

import br.com.belaAgenda.infra.resourceBundle.ResourceBundleFactory;

@SuppressWarnings("rawtypes")
public abstract class BaseBusinessImpl<T, D extends BaseDao> implements BaseBusiness<T, D>{
	
	@Inject
	protected D dao;
	
	private ResourceBundle resourceBundle = ResourceBundleFactory.createBundle(getClass());
	
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
		return (T) dao.delete(entity);
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
	
	public String getMessage(String key){
		return resourceBundle.getString(key);
	}
	
}
