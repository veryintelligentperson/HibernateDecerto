package pl.decerto.techflash.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Formula;

@Data
@Entity
@Table(name="COMPANY_USER")
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

	@Column(name = "CREATED_DATE", updatable = false)
	private Date createdDate;

	@Column(name = "EMAIL")
	private String email;

//	@ElementCollection
//	@CollectionTable(name = "REGISTRATION_NUMBER", joinColumns = @JoinColumn(name ="USER_ID"))
//	@Column(name = "NUMBER")
//	private List<String> registrationNumbers;

	@ElementCollection
	@CollectionTable(name = "REGISTRATION_NUMBER", joinColumns = @JoinColumn(name ="USER_ID"))
	@MapKeyColumn(name = "KEY")
	@Column(name = "NUMBER")
	private Map<String, String> registrationNumbers;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "VALID_TILL")
	private Date validTill;

	@ElementCollection
	@CollectionTable(name = "USER_ADDRESS", joinColumns =@JoinColumn(name = "USER_ID"))
	@AttributeOverrides({@AttributeOverride(name = "country",column=@Column(name = "HOMELAND"))})
	private List<Address> addresses;

//	@Embedded
//	@AttributeOverrides({@AttributeOverride(name = "country",column=@Column(name = "HOMELAND"))})
//	private Address address;

}
