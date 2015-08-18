package interview.core.service.test.builder;

import java.math.BigDecimal;

import interview.core.form.TransferForm;

public class TransferBuilder {

	private static TransferBuilder transferBuilder;
	private TransferForm transfer;
	
	private TransferBuilder(TransferForm transfer) {
		this.transfer = transfer;
	}
	
	public static TransferBuilder newTransfer() {
		transferBuilder = new TransferBuilder(new TransferForm());
		return transferBuilder;
	}

	public TransferBuilder withAccountFrom(Long l) {
		transfer.setAccountNoFrom(l);
		return transferBuilder;
	}

	public TransferBuilder withAccountTo(Long l) {
		transfer.setAccountNoTo(l);
		return transferBuilder;
	}
	
	public TransferBuilder withAmount(Long l) {
		transfer.setAmount(new BigDecimal(l));
		return transferBuilder;
	}
	
	public TransferForm create() {
		return transferBuilder.transfer;		
	}
}
