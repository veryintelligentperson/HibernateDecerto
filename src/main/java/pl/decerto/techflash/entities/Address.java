package pl.decerto.techflash.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	@Column(name = "ZIP_CODE")
	private String zipCode;

	@Column(name = "HOUSE_NUMBER")
	private String houseNumber;

	@Column(name = "FLAT_NUMBER")
	private String flatNumber;
}
