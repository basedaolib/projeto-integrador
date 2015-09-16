package br.com.belaAgenda.dao.rh.exceptions;

import br.com.belaAgenda.infra.util.BaseException;

public class FuncionarioDaoException extends BaseException {
	private static final long serialVersionUID = -1552381683282579747L;

	public FuncionarioDaoException() {
		super();
	}

	public FuncionarioDaoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public FuncionarioDaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public FuncionarioDaoException(String arg0) {
		super(arg0);
	}

	public FuncionarioDaoException(Throwable arg0) {
		super(arg0);
	}

	
}
