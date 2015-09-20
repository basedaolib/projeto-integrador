package br.com.belaAgenda.dao.glb.exceptions;

import br.com.belaAgenda.infra.util.BaseException;

public class ClienteDaoException extends BaseException {
	private static final long serialVersionUID = -1552381683282579747L;

	public ClienteDaoException() {
		super();
	}

	public ClienteDaoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ClienteDaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ClienteDaoException(String arg0) {
		super(arg0);
	}

	public ClienteDaoException(Throwable arg0) {
		super(arg0);
	}

	
}
