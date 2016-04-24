package pl.decerto.techflash.entities;

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Transaction {

	@Id
	@GeneratedValue
	@Column(name = "TRANSACTION_ID")
	private Long transactionId;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@Column(name = "INITIAL_BALANCE")
	private BigDecimal initialBalance;

	@Column(name = "TRANSACTION_AMOUNT")
	private BigDecimal transactionAmount;

	@Column(name = "CLOSING_BALANCE")
	private BigDecimal closingBalance;

}
