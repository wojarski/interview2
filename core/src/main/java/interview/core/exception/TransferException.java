package interview.core.exception;

public class TransferException extends Exception {
	public enum Reason {
		SRC_ACCOUNT_WRONG, DST_ACCOUNT_WRONG , ACCOUNT_LOCKED, BALANCE_INSUFFICIENT
	}
	
	private static final long serialVersionUID = -6576181803720176309L;
	private final Reason reason;
	
	public TransferException(Reason reason, String message) {
		super(message);
		this.reason = reason;
	}

	public Reason getReason() {
		return reason;
	}

}
