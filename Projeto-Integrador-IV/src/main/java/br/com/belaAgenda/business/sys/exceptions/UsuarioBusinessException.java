package br.com.belaAgenda.business.sys.exceptions;

import br.com.belaAgenda.infra.util.BaseException;

public class UsuarioBusinessException extends BaseException {
	private static final long serialVersionUID = -1552381683282579747L;

	public UsuarioBusinessException() {
		super();
	}

	public UsuarioBusinessException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UsuarioBusinessException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UsuarioBusinessException(String arg0) {
		super(arg0);
	}

	public UsuarioBusinessException(Throwable arg0) {
		super(arg0);
	}

	
}
