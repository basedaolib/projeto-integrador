package br.com.belaAgenda.controller.rh.exceptions;

import br.com.belaAgenda.infra.util.BaseException;

public class FuncionarioBeanException extends BaseException {
	private static final long serialVersionUID = -1552381683282579747L;

	public FuncionarioBeanException() {
		super();
	}

	public FuncionarioBeanException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public FuncionarioBeanException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public FuncionarioBeanException(String arg0) {
		super(arg0);
	}

	public FuncionarioBeanException(Throwable arg0) {
		super(arg0);
	}

	
}
