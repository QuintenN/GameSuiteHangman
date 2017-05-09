package domain;

@SuppressWarnings("serial")
public class DomainException extends RuntimeException {

	public DomainException() {
	}

	public DomainException(String arg0) {
		super(arg0);
	}

	public DomainException(Throwable arg0) {
		super(arg0);
	}

	public DomainException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DomainException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
