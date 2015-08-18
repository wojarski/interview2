package interview.core.service.impl;

import interview.core.exception.TransferException;
import interview.core.exception.TransferException.Reason;
import interview.core.form.TransferForm;
import interview.core.model.Account;
import interview.core.repository.AccountRepository;
import interview.core.service.AccountService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository repository;
	
	@Override
	@Transactional(readOnly = false)
	public void transfer(@Valid TransferForm form) throws TransferException {
		Account srcAccount = repository.findByAccount(form.getAccountNoFrom());
		if(srcAccount == null) {
			throw new TransferException(Reason.SRC_ACCOUNT_WRONG, "source account incorrect");
		}
		Account dstAccount = repository.findByAccount(form.getAccountNoTo());
		if(dstAccount == null) {
			throw new TransferException(Reason.DST_ACCOUNT_WRONG, "destination account incorrect");
		}
		if(form.getAccountNoFrom().equals(form.getAccountNoTo())) {
			throw new TransferException(Reason.DST_ACCOUNT_WRONG, "destination account incorrect");
		}
		if(srcAccount.getBalance().compareTo(form.getAmount()) == -1) {
			throw new TransferException(Reason.BALANCE_INSUFFICIENT, "insufficient balance on account " + form.getAccountNoFrom());
		}
		srcAccount.setBalance(srcAccount.getBalance().subtract(form.getAmount()));
		dstAccount.setBalance(dstAccount.getBalance().add(form.getAmount()));
		repository.save(srcAccount);
		repository.save(dstAccount);
	}

}
