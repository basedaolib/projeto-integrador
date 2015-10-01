package br.com.belaAgenda.model.svc;

import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;

import br.com.belaAgenda.infra.base.model.ChaveValor;
import br.com.belaAgenda.infra.util.LocalDatePersistenceConverter;

@Entity
public class Servico extends ChaveValor {
	private static final long serialVersionUID = 1567595694751855349L;

	@Convert(converter = LocalDatePersistenceConverter.class)
	private LocalDateTime tempoMedio;
	
}
