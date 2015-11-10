package br.com.belaAgenda.infra.base.business;

import java.util.List;

import br.com.belaAgenda.infra.base.model.EntityId;
import br.com.generic.dao.SearchBuilder;
import br.com.generic.dao.SearchEntityBuilder;
import br.com.generic.dao.SearchEntityListBuilder;
import br.com.generic.dao.SearchListBuilder;

public interface BaseBusiness<T extends EntityId>{
	
	public T insert(T entity);

	public T delete(T entity);

	public T update(T entity);
	
	public T save(T entity);
	
	public T inativar(T entity);

	public T disassociate(T entity);

	public T findEntityById(long id);

    public List<T> list(int beginning, int end, String order);

	public SearchEntityListBuilder<T> listEntities();

	public SearchEntityBuilder<T> searchEntity();

    public <E> SearchListBuilder<T, E> listProperties(String field);

    public<E> SearchBuilder<T, E> searchProperty(String field);

	

}
