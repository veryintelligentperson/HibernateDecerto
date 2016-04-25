package pl.decerto.techflash.entities;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class Room {

	private Long roomId;

	private Integer roomSize;

	private BigDecimal price;

	private List<Reservation> reservations;

}
