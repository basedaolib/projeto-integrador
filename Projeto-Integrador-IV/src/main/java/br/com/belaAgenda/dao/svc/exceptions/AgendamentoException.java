package br.com.belaAgenda.dao.svc.exceptions;

import br.com.belaAgenda.infra.util.BaseException;

public class AgendamentoException extends BaseException {

	private static final long serialVersionUID = -5549128304363099328L;
	public AgendamentoException() {
	}

	public AgendamentoException(String message) {
		super(message);
	}

	public AgendamentoException(Throwable cause) {
		super(cause);
	}

	public AgendamentoException(String message, Throwable cause) {
		super(message, cause);
	}

	public AgendamentoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
