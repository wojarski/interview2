package interview.core.exception;

public class AccountException extends Exception {
	private static final long serialVersionUID = -7904209077320744661L;

	public AccountException(Exception e) {
		super(e);
	}
}
