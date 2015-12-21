package exception;

public class NoSuchIDExceptions extends Exception {
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 4996119679783148669L;

	public NoSuchIDExceptions() {
		super();
	}

	public NoSuchIDExceptions(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public NoSuchIDExceptions(String detailMessage) {
		super(detailMessage);
	}

	public NoSuchIDExceptions(Throwable throwable) {
		super(throwable);
	}
}
