package br.com.belaAgenda.infra.resourceBundle.exceptions;

import br.com.belaAgenda.infra.util.BaseException;

public class MessageProviderExceptions extends BaseException {

	private static final long serialVersionUID = 1594454005849653645L;

	public MessageProviderExceptions() {
	}

	public MessageProviderExceptions(String message) {
		super(message);
	}

	public MessageProviderExceptions(Throwable cause) {
		super(cause);
	}

	public MessageProviderExceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public MessageProviderExceptions(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
