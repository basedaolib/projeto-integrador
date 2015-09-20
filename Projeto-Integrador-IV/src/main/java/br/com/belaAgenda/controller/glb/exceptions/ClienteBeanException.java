package br.com.belaAgenda.controller.glb.exceptions;

import br.com.belaAgenda.infra.util.BaseException;

public class ClienteBeanException extends BaseException {
	private static final long serialVersionUID = -1552381683282579747L;

	public ClienteBeanException() {
		super();
	}

	public ClienteBeanException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ClienteBeanException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ClienteBeanException(String arg0) {
		super(arg0);
	}

	public ClienteBeanException(Throwable arg0) {
		super(arg0);
	}

	
}
