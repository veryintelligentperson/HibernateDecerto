package pl.decerto.techflash.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "RESERVATION")
public class Reservation {

	@Id
	@GeneratedValue
	@Column(name = "RESERVATION_ID")
	private Long reservationId;

	@Column(name = "FROM_DATE")
	@Temporal(value = TemporalType.DATE)
	private Date from;

	@Column(name = "TILL_DATE")
	@Temporal(value = TemporalType.DATE)
	private Date to;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private HotelAccount account;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ROOM_RESERVATION", joinColumns =@JoinColumn(name = "RESERVATION_ID"),
			inverseJoinColumns = @JoinColumn(name = "ROOM_ID"))
	private List<Room> rooms;

}
