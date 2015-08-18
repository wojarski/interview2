package interview.core.service.test;


import interview.core.conf.CoreConf;
import interview.core.exception.TransferException;
import interview.core.exception.TransferException.Reason;
import interview.core.form.TransferForm;
import interview.core.model.Account;
import interview.core.repository.AccountRepository;
import interview.core.service.AccountService;
import interview.core.service.test.builder.AccounBuilder;
import interview.core.service.test.builder.TransferBuilder;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringApplicationConfiguration(classes = CoreConf.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest {

	@Autowired
	AccountRepository repository;
	
	@Autowired
	AccountService service;
	
	@Test
	public void testTransfer() {
		try {
			TransferForm transfer = TransferBuilder.newTransfer().withAccountFrom(12345678l).withAccountTo(87654321l).withAmount(50l).create();
			createTwoAccounts(12345678l, 87654321l);
			
			service.transfer(transfer);
			
		} catch (TransferException e) {
			e.printStackTrace();
			Assert.fail();
		} 
	}
	
	@Test
	public void testTransferWrongSrcAccount() {
		try {
			createTwoAccounts(12345678l, 87654321l);
			TransferForm transfer = TransferBuilder.newTransfer().withAccountFrom(92345678l).withAccountTo(87654321l).withAmount(50l).create();
			
			service.transfer(transfer);
		} catch (TransferException e) {
			if(e.getReason().equals(Reason.SRC_ACCOUNT_WRONG)) {
				return;
			}
		} 
		Assert.fail();
	}
	
	@Test
	public void testTransferWrongDstAccount() {
		try {
			createTwoAccounts(12345678l, 87654321l);
			TransferForm transfer = TransferBuilder.newTransfer().withAccountFrom(12345678l).withAccountTo(97654321l).withAmount(50l).create();
			
			service.transfer(transfer);
		} catch (TransferException e) {
			if(e.getReason().equals(Reason.DST_ACCOUNT_WRONG)) {
				return;
			}
		} 
		Assert.fail();
	}
	@Test
	public void testTransferSameAccount() {
		try {
			createTwoAccounts(12345678l, 87654321l);
			TransferForm transfer = TransferBuilder.newTransfer().withAccountFrom(12345678l).withAccountTo(12345678l).withAmount(50l).create();
			
			service.transfer(transfer);
		} catch (TransferException e) {
			if(e.getReason().equals(Reason.DST_ACCOUNT_WRONG)) {
				return;
			}
		} 
		Assert.fail();
	}
	
	@Test
	public void testTransferInsufficientBalance() {
		try {
			createTwoAccounts(12345678l, 87654321l);
			TransferForm transfer = TransferBuilder.newTransfer().withAccountFrom(12345678l).withAccountTo(87654321l).withAmount(500l).create();
			
			service.transfer(transfer);
		} catch (TransferException e) {
			if(e.getReason().equals(Reason.BALANCE_INSUFFICIENT)) {
				return;
			}
		} 
		Assert.fail();
	}

	private void createTwoAccounts(Long srcAccNo, Long dstAccNo) {
		BigDecimal srcBal = new BigDecimal(200);
		BigDecimal dstBal = new BigDecimal(0);
		
		Account srcAccount = AccounBuilder.newAccount(1l).withNumber(srcAccNo).withBalance(srcBal).create();
		repository.save(srcAccount);
		Account dstAccount = AccounBuilder.newAccount(2l).withNumber(dstAccNo).withBalance(dstBal).create();
		repository.save(dstAccount);
		
	}
	
	
}