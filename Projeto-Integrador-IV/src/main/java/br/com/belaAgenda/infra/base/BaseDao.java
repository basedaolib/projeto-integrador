package br.com.belaAgenda.infra.base;

import br.com.baseDAOLib.DAO.BaseDAO;

public interface BaseDao<T> extends BaseDAO<T> {

	public String getMessage(String key);
}
