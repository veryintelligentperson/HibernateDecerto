package pl.decerto.techflash;

import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.hibernate.Session;
import pl.decerto.techflash.entities.Address;
import pl.decerto.techflash.entities.Credential;
import pl.decerto.techflash.entities.HotelAccount;
import pl.decerto.techflash.entities.Reservation;
import pl.decerto.techflash.entities.Room;
import pl.decerto.techflash.utils.HibernateUtil;

public class App {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.getTransaction().begin();
			session.save(getAccount("Michal", "Kowalski", "Warszawa"));
			session.save(getAccount("Wojciech", "Nowak", "Gdansk"));
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}

	private static HotelAccount getAccount(String name, String lastName, String city) {
		HotelAccount hotelAccount = new HotelAccount();
		hotelAccount.setReservations(getReservationsList(hotelAccount));
		hotelAccount.setAddress(getAddressInstance(city));
		hotelAccount.setCredential(getCredentialInstance(hotelAccount));
		hotelAccount.setFirstName(name);
		hotelAccount.setLastName(lastName);
		return hotelAccount;
	}

	private static Room getRoomInstance(HotelAccount hotelAccount) {
		Room room = new Room();
		room.setPrice(BigDecimal.valueOf(Math.random() * 1000));
		room.setReservations(getReservationsList(hotelAccount));
		room.setRoomSize(3);
	}

	private static List<Reservation> getReservationsList(HotelAccount hotelAccount) {
		Reservation reservation = new Reservation();
		reservation.setAccount(hotelAccount);
		reservation.setFrom(new Date());
		reservation.setTo(DateUtils.addDays(new Date(), 7));
		reservation.setRooms(Lists.newArrayList(getRoomInstance(hotelAccount), getRoomInstance(hotelAccount)));
	}

	private static Address getAddressInstance(String city) {
		Address address = new Address();
		address.setCity(city);
		address.setCountry("Polska");
		address.setState("Mazowieckie");
		address.setFlatNumber("22");
		address.setHouseNumber("32");
		address.setZipCode("94-333");
		return address;
	}

	private static Credential getCredentialInstance(HotelAccount hotelAccount) {
		Credential credential = new Credential();
		credential.setPassword(RandomStringUtils.random(8));
		credential.setUsername(hotelAccount.getFirstName() + hotelAccount.getLastName());
		credential.setAccount(hotelAccount);
		return credential;
	}
}
