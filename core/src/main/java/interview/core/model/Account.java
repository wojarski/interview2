package interview.core.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    @Column(nullable=false, unique = true)
    private Long number;
    
    @Column
    private BigDecimal balance = new BigDecimal(0);

    public Account() {
    }
    
    public Account(Long id) {
    	this.id = id;
    }
    
    @Override
    public String toString() {
        return String.format("Account[id=%d, number='%d', balance='%s']", id, number, balance);
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}

