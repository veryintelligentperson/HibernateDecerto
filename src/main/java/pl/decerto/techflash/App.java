package pl.decerto.techflash;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.time.DateUtils;
import org.hibernate.Session;
import pl.decerto.techflash.entities.Address;
import pl.decerto.techflash.entities.Car;
import pl.decerto.techflash.entities.CompanyAccount;
import pl.decerto.techflash.entities.Credential;
import pl.decerto.techflash.entities.Transaction;
import pl.decerto.techflash.entities.User;
import pl.decerto.techflash.utils.HibernateUtil;

public class App {

	public static void main(String[] args) {

		User user = getUserInstance("Michal");

		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("BEFORE SAVING ENTITY:\n");
		System.out.println(session.contains(user));

		try {
			session.getTransaction().begin();
			session.save(user);
			System.out.println("\nAFTER SAVING ENTITY:\n");
			System.out.println(session.contains(user));
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}

	private static User getUserInstance(String name) {
		User user = new User();
		user.setBirthDate(new Date());
		user.setCars(Lists.newArrayList(getCarInstance("hgf233"), getCarInstance("asd233")));
		user.setCreatedDate(new Date());
		user.setEmail("asdas@gmail.com");
		user.setFirstName(name);
		user.setTransactions(getTransactions());
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

	private static Credential getCredentialInstance(User user) {
		Credential credential = new Credential();
		credential.setPassword("warta1a2345");
		credential.setUsername("tomcio234");
		credential.setUser(user);
		return credential;
	}

	private static List<Transaction> getTransactions() {
		Transaction transaction1 = new Transaction();
		//transaction1.setUser(getUserInstance());
		transaction1.setInitialBalance(BigDecimal.valueOf(2000));
		transaction1.setTransactionAmount(BigDecimal.valueOf(-300));
		transaction1.setClosingBalance(transaction1.getInitialBalance().add(transaction1.getTransactionAmount()));

		Transaction transaction2 = new Transaction();
		//transaction2.setUser(getUserInstance());
		transaction2.setInitialBalance(BigDecimal.valueOf(1000));
		transaction2.setTransactionAmount(BigDecimal.valueOf(-300));
		transaction2.setClosingBalance(transaction1.getInitialBalance().add(transaction1.getTransactionAmount()));

		return Lists.newArrayList(transaction1, transaction2);
	}

	private static CompanyAccount getCompanyAccountInstance() {
		CompanyAccount companyAccount = new CompanyAccount();
		companyAccount.setCompanyName("WARTA");
		companyAccount.setNip("123123");
		companyAccount.setRegon("12333321");
		companyAccount.setUsers(Lists.newArrayList(getUserInstance("Wojtek"), getUserInstance("Marcin")));
		return companyAccount;
	}

	private static Car getCarInstance(String registrationNumber) {
		Car car = new Car();
		car.setModel("Transit");
		car.setRegistrationNumber(registrationNumber);
		return car;
	}
}
