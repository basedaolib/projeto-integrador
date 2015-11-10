package br.com.belaAgenda.business.svc;

import br.com.belaAgenda.infra.base.business.BaseBusiness;
import br.com.belaAgenda.model.svc.Agendamento;

public interface AgendamentoBusiness extends BaseBusiness<Agendamento> {

	public Agendamento iniciarAtendimento(Agendamento agendamento);
	
	public Agendamento terminarAtendimento(Agendamento agendamento);
		
}
