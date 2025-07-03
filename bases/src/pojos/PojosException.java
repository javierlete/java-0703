package pojos;

public class PojosException extends RuntimeException {
	private static final long serialVersionUID = 3930034745937024042L;

	public PojosException() {
		super();
	}

	public PojosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PojosException(String message, Throwable cause) {
		super(message, cause);
	}

	public PojosException(String message) {
		super(message);
	}

	public PojosException(Throwable cause) {
		super(cause);
	}
}
