package pl.decerto.techflash.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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

	@OneToOne()
	@JoinColumns({@JoinColumn(name = "FIRST_NAME"), @JoinColumn(name = "LAST_NAME")})
	private User user;

	private String username;

	private String password;


}
