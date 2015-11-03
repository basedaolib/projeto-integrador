package br.com.belaAgenda.infra.base.dao;

import br.com.belaAgenda.infra.base.model.EntityId;
import br.com.generic.dao.GenericDAO;

public interface BaseDao<T extends EntityId> extends GenericDAO<T> {

	public T save(T entity);
	public T inativar(T entity);
	public String getMessage(String key);
}
