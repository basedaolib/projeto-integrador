package br.com.belaAgenda.infra.resourceBundle;



public class ResourceBundleException extends RuntimeException{

	private static final long serialVersionUID = 1394891202027282275L;

	
	public ResourceBundleException() {
		super();

	}

	public ResourceBundleException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public ResourceBundleException(String message, Throwable cause) {
		super(message, cause);

	}

	public ResourceBundleException(String message) {
		super(message);

	}

	public ResourceBundleException(Throwable cause) {
		super(cause);

	}

	
}
