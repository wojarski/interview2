package interview.core.form;

import java.math.BigDecimal;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

public class TransferForm {
	@NotNull
	private Long accountNoFrom;
	
	@NotNull
	private Long accountNoTo;
	
	@NotNull
	@NumberFormat(pattern = ".##")
	private BigDecimal amount;
	
	private Map<String, String> errors;
	
	public Long getAccountNoFrom() {
		return accountNoFrom;
	}
	public void setAccountNoFrom(Long accountNoFrom) {
		this.accountNoFrom = accountNoFrom;
	}
	public Long getAccountNoTo() {
		return accountNoTo;
	}
	public void setAccountNoTo(Long accountNoTo) {
		this.accountNoTo = accountNoTo;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	
}
