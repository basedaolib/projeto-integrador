package br.com.belaAgenda.model.svc.exceptions;

import br.com.belaAgenda.infra.util.BaseException;

public class AgendamentoException extends BaseException {

	private static final long serialVersionUID = 4919203891043059418L;

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

	public AgendamentoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
