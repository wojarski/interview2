package interview.core.service.test.builder;

import java.math.BigDecimal;

import interview.core.model.Account;

public class AccounBuilder {

	private static AccounBuilder accBuilder;
	private Account account;
	
	private AccounBuilder(Account account) {
		this.account = account;
	}
	
	public static AccounBuilder newAccount(Long id) {
		accBuilder = new AccounBuilder(new Account(id));
		return accBuilder;
	}

	public AccounBuilder withNumber(Long accNumber) {
		account.setNumber(accNumber);
		return accBuilder; 
	}

	public AccounBuilder withBalance(BigDecimal balance) {
		account.setBalance(balance);
		return accBuilder; 
	}

	public Account create() {
		return accBuilder.account;		
	}
	
}
