package br.com.belaAgenda.business.rh.exceptions;

import br.com.belaAgenda.infra.util.BaseException;

public class FuncionarioBusinessException extends BaseException {
	private static final long serialVersionUID = -1552381683282579747L;

	public FuncionarioBusinessException() {
		super();
	}

	public FuncionarioBusinessException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public FuncionarioBusinessException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public FuncionarioBusinessException(String arg0) {
		super(arg0);
	}

	public FuncionarioBusinessException(Throwable arg0) {
		super(arg0);
	}

	
}
