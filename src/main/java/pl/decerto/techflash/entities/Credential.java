package pl.decerto.techflash.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	private HotelAccount account;

	private String username;

	private String password;

}
