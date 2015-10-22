package br.com.belaAgenda.infra.base.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.belaAgenda.infra.base.model.ChaveValor;

public abstract class ChaveValorDaoImpl<T extends ChaveValor> extends BaseDaoImpl<T> {
	
	private static final long serialVersionUID = 7315829537951727L;

	@Override
	protected T beforeInsert(T entity) {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<? extends ChaveValor> productRoot = criteria.from(entity.getClass());
		criteria.select(builder.max(productRoot.get("codigo")));
		Long codigo = getEntityManager().createQuery(criteria).getSingleResult();
	
		if(codigo == null){
			codigo = 1L;
		}else{
			codigo++;
		}
		entity.setCodigo(codigo);
		
		return super.beforeInsert(entity);
	}
}
