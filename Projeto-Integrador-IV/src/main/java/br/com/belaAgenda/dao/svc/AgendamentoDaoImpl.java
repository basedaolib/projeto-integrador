package br.com.belaAgenda.dao.svc;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.belaAgenda.infra.base.dao.BaseDaoImpl;
import br.com.belaAgenda.model.svc.Agendamento;
import br.com.belaAgenda.model.svc.exceptions.AgendamentoException;
import br.com.belaAgenda.model.svc.type.StatusAgendamento;
import br.com.generic.dao.SearchEntityListBuilder;

public class AgendamentoDaoImpl extends BaseDaoImpl<Agendamento> implements AgendamentoDao {

	private static final long serialVersionUID = 1689413334696665422L;
	
	@Override
	protected Agendamento beforeInsert(Agendamento entity) {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Agendamento> productRoot = criteria.from(Agendamento.class);
		criteria.select(builder.max(productRoot.get("codigo")));
		Long codigo = getEntityManager().createQuery(criteria).getSingleResult();
	
		if(codigo == null){
			codigo = 1L;
		}else{
			codigo++;
		}
		entity.setCodigo(codigo);
		entity.setStatus(StatusAgendamento.AGENDADO);
		
		return super.beforeInsert(entity);
	}
	
	@Override
	protected Agendamento consist(Agendamento entity) {
		if(entity.getStatus() != StatusAgendamento.CANCELADO){
			SearchEntityListBuilder<Agendamento> builder = listEntities()
					.equal("cliente", entity.getCliente())
					.equal("funcionario", entity.getFuncionario())
					.in("status", StatusAgendamento.AGENDADO, StatusAgendamento.EN_ANDAMENTO)
					.between("data", entity.getData(), entity.getFinalEstimado())
					.between("finalEstimado", entity.getData(), entity.getFinalEstimado());
			
			if(entity.getId() == 0){
				builder.notEqual("id", entity.getId());
			}
			
			List<Agendamento> agendamentosCadastrados = builder.list();
			
			if(!agendamentosCadastrados.isEmpty()){
				throw new AgendamentoException(getMessage("agendamentoDao.horarioJaEmUso"));
			}
		}
		
		return super.consist(entity);
	}

}
