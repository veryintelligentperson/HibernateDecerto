package pl.decerto.techflash.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "HOTEL_ACCOUNT")
public class HotelAccount {

	@Id
	@GeneratedValue
	@Column(name = "HOTEL_ACCOUNT_ID")
	private Long hotelAccountId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Embedded
	private Address address;

	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
	private Credential credential;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
	private List<Reservation> reservations;

}
