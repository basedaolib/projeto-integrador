package br.com.belaAgenda.infra.base.model.exceptions;

import br.com.belaAgenda.infra.util.BaseException;

public class ChaveValorModelException extends BaseException {


	private static final long serialVersionUID = 1559055107817022988L;

	public ChaveValorModelException() {
	}

	public ChaveValorModelException(String message) {
		super(message);
	}

	public ChaveValorModelException(Throwable cause) {
		super(cause);
	}

	public ChaveValorModelException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChaveValorModelException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
