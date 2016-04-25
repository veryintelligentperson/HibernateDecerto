package pl.decerto.techflash.entities;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ROOM")
public class Room {

	@Id
	@GeneratedValue
	@Column(name = "ROOM_ID")
	private Long roomId;

	@Column(name = "ROOM_SIZE")
	private Integer roomSize;

	@Column(name = "PRICE")
	private BigDecimal price;

	@ManyToMany(mappedBy = "rooms")
	private List<Reservation> reservations;

}
