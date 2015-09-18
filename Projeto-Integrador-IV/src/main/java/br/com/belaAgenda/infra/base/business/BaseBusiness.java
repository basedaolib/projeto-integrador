package br.com.belaAgenda.infra.base.business;

import java.util.List;

import br.com.belaAgenda.infra.base.model.EntityId;

public interface BaseBusiness<T extends EntityId>{
	
	public T insert(T entity);

	public T delete(T entity);

	public T update(T entity);
	
	public T save(T entity);
	
	public T inativar(T entity);

	public T disassociate(T entity);

	public T findEntityForId(long id);
	
	public List<T> list(int beginning, int end, String order);

	public List<T> findEntitiesForProperties(int beginning, int end, String order, String names, Object... values);

	public T findEntityForProperties(String names, Object... values);

	public <E> List<E> findFieldsForProperties(int beginning, int end, String order, String field, String names,
			Object... values);

	public <E> E findFieldForProperties(String field, String names, Object... values);
	
	public String getMessage(String key);

}
