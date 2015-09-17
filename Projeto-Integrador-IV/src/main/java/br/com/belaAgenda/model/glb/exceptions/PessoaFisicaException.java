package br.com.belaAgenda.model.glb.exceptions;

import br.com.belaAgenda.infra.util.BaseException;

public class PessoaFisicaException extends BaseException {

	
	private static final long serialVersionUID = 4049148555966366394L;

	public PessoaFisicaException() {
	}

	public PessoaFisicaException(String message) {
		super(message);
	}

	public PessoaFisicaException(Throwable cause) {
		super(cause);
	}

	public PessoaFisicaException(String message, Throwable cause) {
		super(message, cause);
	}

	public PessoaFisicaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
