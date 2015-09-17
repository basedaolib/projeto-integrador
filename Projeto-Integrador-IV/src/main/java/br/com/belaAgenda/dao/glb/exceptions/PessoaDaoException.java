package br.com.belaAgenda.dao.glb.exceptions;

import br.com.belaAgenda.infra.util.BaseException;

public class PessoaDaoException extends BaseException {

	private static final long serialVersionUID = -7940795356523378098L;

	public PessoaDaoException() {
	}

	public PessoaDaoException(String message) {
		super(message);
	}

	public PessoaDaoException(Throwable cause) {
		super(cause);
	}

	public PessoaDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public PessoaDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
