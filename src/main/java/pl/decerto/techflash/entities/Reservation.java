package pl.decerto.techflash.entities;

import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class Reservation {

	private Long reservationId;

	private Date from;

	private Date to;

	private HotelAccount account;

	private List<Room> rooms;

}
