package br.com.belaAgenda.model.sys.exceptions;

import br.com.belaAgenda.infra.util.BaseException;

public class UsuarioModelException extends BaseException {

	private static final long serialVersionUID = -8107200734792087407L;

	public UsuarioModelException() {
		super();
	}

	public UsuarioModelException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UsuarioModelException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UsuarioModelException(String arg0) {
		super(arg0);
	}

	public UsuarioModelException(Throwable arg0) {
		super(arg0);
	}

	
}
