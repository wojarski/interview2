package interview.core.service;

import interview.core.exception.TransferException;
import interview.core.form.TransferForm;

public interface AccountService {
	public void transfer(TransferForm form) throws TransferException;
	
}
