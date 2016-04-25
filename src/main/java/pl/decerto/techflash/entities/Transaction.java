package pl.decerto.techflash.entities;

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.criteria.Join;
import lombok.Data;

@Data
@Entity
@Table(name = "TRANSACTION")
public class Transaction {

	@Id
	@GeneratedValue
	@Column(name = "TRANSACTION_ID")
	private Long transactionId;

	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;

	@ManyToOne()
	@JoinColumns({@JoinColumn(name = "FIRST_NAME"), @JoinColumn(name = "LAST_NAME")})
	private User user;

	@Column(name = "INITIAL_BALANCE")
	private BigDecimal initialBalance;

	@Column(name = "TRANSACTION_AMOUNT")
	private BigDecimal transactionAmount;

	@Column(name = "CLOSING_BALANCE")
	private BigDecimal closingBalance;

}
