package br.com.belaAgenda.infra.base.dao;

import br.com.baseDAOLib.DAO.BaseDAO;
import br.com.belaAgenda.infra.base.model.EntityId;

public interface BaseDao<T extends EntityId> extends BaseDAO<T> {

	public T save(T entity);
	public String getMessage(String key);
}
