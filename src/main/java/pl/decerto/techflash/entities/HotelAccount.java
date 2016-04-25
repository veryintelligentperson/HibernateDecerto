package pl.decerto.techflash.entities;

import java.util.List;
import lombok.Data;

@Data
public class HotelAccount {

	private Long hotelAccountId;

	private String firstName;

	private String lastName;

	private Address address;

	private Credential credential;

	private List<Reservation> reservations;

}
