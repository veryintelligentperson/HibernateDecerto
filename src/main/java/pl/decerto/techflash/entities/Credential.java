package pl.decerto.techflash.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CREDENTIAL")
public class Credential {

	@Id
	@GeneratedValue
	@Column(name = "CREDENTIAL_ID")
	private Long credentialId;

	@OneToOne
	@JoinColumn(name = "HOTEL_ACCOUNT_ID")
	private HotelAccount account;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

}
