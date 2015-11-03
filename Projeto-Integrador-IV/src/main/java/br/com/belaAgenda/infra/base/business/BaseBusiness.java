package br.com.belaAgenda.infra.base.business;

import java.util.List;

import br.com.belaAgenda.infra.base.model.EntityId;
import br.com.generic.dao.WhereBuilder;
import br.com.generic.dao.WhereEntityBuilder;
import br.com.generic.dao.WhereEntityListBuilder;
import br.com.generic.dao.WhereListBuilder;

public interface BaseBusiness<T extends EntityId>{
	
	public T insert(T entity);

	public T delete(T entity);

	public T update(T entity);
	
	public T save(T entity);
	
	public T inativar(T entity);

	public T disassociate(T entity);

	public T findEntityById(long id);

    public List<T> list(int beginning, int end, String order);

	public WhereEntityListBuilder<T> listEntities();

	public WhereEntityBuilder<T> searchEntity();

    public <E> WhereListBuilder<T, E> listProperties(String field);

    public<E> WhereBuilder<T, E> searchProperty(String field);

	

}
