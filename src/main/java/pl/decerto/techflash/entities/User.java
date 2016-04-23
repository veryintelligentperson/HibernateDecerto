package pl.decerto.techflash.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="USER")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "BIRTH_DATE")
	private Date birthDate;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "VALID_TILL")
	private Date validTill;

}
