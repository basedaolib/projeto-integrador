package br.com.belaAgenda.business.svc;

import java.time.LocalDateTime;

import br.com.belaAgenda.dao.svc.AgendamentoDao;
import br.com.belaAgenda.infra.base.business.BaseBusinessImpl;
import br.com.belaAgenda.model.svc.Agendamento;
import br.com.belaAgenda.model.svc.type.StatusAgendamento;

public class AgendamentoBusinessImpl extends BaseBusinessImpl<Agendamento, AgendamentoDao> implements AgendamentoBusiness {

	private static final long serialVersionUID = -1813596324642553648L;

	@Override
	public Agendamento iniciarAtendimento(Agendamento agendamento){
		agendamento.setInicioAtendimento(LocalDateTime.now());
		agendamento.setStatus(StatusAgendamento.EN_ANDAMENTO);
		return update(agendamento);
	}
	
	@Override
	public Agendamento terminarAtendimento(Agendamento agendamento){
		agendamento.setFinalAtendimento(LocalDateTime.now());
		agendamento.setStatus(StatusAgendamento.CONCLUIDO);
		return update(agendamento);
	}

	@Override
	public Agendamento cancelarAtendimento(Agendamento agendamento) {
		agendamento.setDataCancelamento(LocalDateTime.now());
		agendamento.setStatus(StatusAgendamento.CANCELADO);
		return update(agendamento);
	}
}
