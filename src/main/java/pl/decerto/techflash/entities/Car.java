package pl.decerto.techflash.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Car {

	@Id
	@GeneratedValue
	@Column(name = "CAR_ID")
	private Long carId;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "cars")
	private List<User> users;

	@Column(name = "MODEL")
	private String model;

	@Column(name = "REGISTRATION_NUMBER")
	private String registrationNumber;

}
