package br.com.belaAgenda.model.glb.exceptions;

import br.com.belaAgenda.infra.util.BaseException;

public class ContatoException extends BaseException {

	private static final long serialVersionUID = 4919203891043059418L;

	public ContatoException() {
	}

	public ContatoException(String message) {
		super(message);
	}

	public ContatoException(Throwable cause) {
		super(cause);
	}

	public ContatoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ContatoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
