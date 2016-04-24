package pl.decerto.techflash;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Date;
import java.util.Map;
import org.apache.commons.lang.time.DateUtils;
import org.hibernate.Session;
import pl.decerto.techflash.entities.Address;
import pl.decerto.techflash.entities.User;
import pl.decerto.techflash.utils.HibernateUtil;

public class App {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();

			User user = getUserInstance();
			session.save(user);
			session.getTransaction().commit();

			session.beginTransaction();

			User dbUser = (User) session.get(User.class, user.getUserId());
			dbUser.setFirstName("somethingDifferent");
			dbUser.setCreatedDate(DateUtils.addDays(new Date(), 1));

			session.update(dbUser);
			session.getTransaction().commit();
		}catch (Exception e){
			e.printStackTrace();
		}
		session.close();
	}

	private static User getUserInstance(){
		User user = new User();
		user.setBirthDate(new Date());
		user.setCreatedDate(new Date());
		user.setEmail("asdas@gmail.com");
		user.setFirstName("Michal");
		user.setLastName("Stepniak");
		user.setPhoneNumber("3322123123");
		user.setAddresses(Lists.newArrayList(getAddressInstance("warszawa"), getAddressInstance("wroclaw")));
		user.setValidTill(DateUtils.addMonths(new Date(), 1));
		Map<String, String> map = Maps.newHashMap();
		map.put("someKey", "ONY123");
		map.put("someKey2", "OKU233");
		user.setRegistrationNumbers(map);
		return user;
	}

	private static Address getAddressInstance(String city){
		Address address = new Address();
		address.setCity(city);
		address.setCountry("Polska");
		address.setState("Mazowieckie");
		address.setFlatNumber("22");
		address.setHouseNumber("32");
		address.setZipCode("94-333");
		return address;
	}
}
