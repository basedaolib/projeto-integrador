package br.com.belaAgenda.dao.sys.exceptions;

import br.com.belaAgenda.infra.util.BaseException;

public class UsuarioDaoException extends BaseException {
	private static final long serialVersionUID = -1552381683282579747L;

	public UsuarioDaoException() {
		super();
	}

	public UsuarioDaoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UsuarioDaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UsuarioDaoException(String arg0) {
		super(arg0);
	}

	public UsuarioDaoException(Throwable arg0) {
		super(arg0);
	}

	
}
