package br.com.belaAgenda.business.glb.exceptions;

import br.com.belaAgenda.infra.util.BaseException;

public class ClienteBusinessException extends BaseException {
	private static final long serialVersionUID = -1552381683282579747L;

	public ClienteBusinessException() {
		super();
	}

	public ClienteBusinessException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ClienteBusinessException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ClienteBusinessException(String arg0) {
		super(arg0);
	}

	public ClienteBusinessException(Throwable arg0) {
		super(arg0);
	}

	
}
