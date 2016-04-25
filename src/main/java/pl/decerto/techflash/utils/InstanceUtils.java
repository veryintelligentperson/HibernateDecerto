package pl.decerto.techflash.utils;

import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateUtils;
import pl.decerto.techflash.entities.Address;
import pl.decerto.techflash.entities.Credential;
import pl.decerto.techflash.entities.HotelAccount;
import pl.decerto.techflash.entities.Reservation;
import pl.decerto.techflash.entities.Room;

public class InstanceUtils {

	private static Room roomOne = new Room();
	private static Room roomTwo = new Room();
	private static Reservation reservationOne = new Reservation();
	private static Reservation reservationTwo = new Reservation();

	public static HotelAccount getAccount(String name, String lastName, String city) {
		HotelAccount hotelAccount = new HotelAccount();
		hotelAccount.setFirstName(name);
		hotelAccount.setLastName(lastName);
		hotelAccount.setAddress(getAddressInstance(city));
		hotelAccount.setReservations(getReservations(hotelAccount));
		hotelAccount.setCredential(getCredentialInstance(hotelAccount));
		return hotelAccount;
	}

	public static List<Room> getRooms() {
		roomOne.setPrice(BigDecimal.valueOf(Math.random() * 1000));
		roomOne.setReservations(Lists.newArrayList(reservationOne, reservationTwo));
		roomOne.setRoomSize(3);

		roomTwo.setPrice(BigDecimal.valueOf(Math.random() * 1000));
		roomTwo.setReservations(Lists.newArrayList(reservationOne, reservationTwo));
		roomTwo.setRoomSize(2);

		return Lists.newArrayList(roomOne, roomTwo);
	}

	public static List<Reservation> getReservations(HotelAccount hotelAccount) {
		reservationOne.setAccount(hotelAccount);
		reservationOne.setFrom(new Date());
		reservationOne.setTo(DateUtils.addDays(new Date(), 7));
		reservationOne.setRooms(Lists.newArrayList(getRooms()));

		reservationTwo.setAccount(hotelAccount);
		reservationTwo.setFrom(new Date());
		reservationTwo.setTo(DateUtils.addDays(new Date(), 7));
		reservationTwo.setRooms(Lists.newArrayList(getRooms()));

		return Lists.newArrayList(reservationTwo, reservationOne);
	}

	public static Address getAddressInstance(String city) {
		Address address = new Address();
		address.setCity(city);
		address.setCountry("Polska");
		address.setState("Mazowieckie");
		address.setFlatNumber("22");
		address.setHouseNumber("32");
		address.setZipCode("94-333");
		return address;
	}

	public static Credential getCredentialInstance(HotelAccount hotelAccount) {
		Credential credential = new Credential();
		credential.setPassword(DigestUtils.md5Hex(hotelAccount.getFirstName()).substring(0,5));
		credential.setUsername(hotelAccount.getFirstName() + hotelAccount.getLastName());
		credential.setAccount(hotelAccount);
		return credential;
	}
}
