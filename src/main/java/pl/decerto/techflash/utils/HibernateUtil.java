package pl.decerto.techflash.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import pl.decerto.techflash.entities.Credential;
import pl.decerto.techflash.entities.HotelAccount;
import pl.decerto.techflash.entities.Reservation;
import pl.decerto.techflash.entities.Room;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(HotelAccount.class);
			configuration.addAnnotatedClass(Credential.class);
			configuration.addAnnotatedClass(Reservation.class);
			configuration.addAnnotatedClass(Room.class);
			configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");
			return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Something went terribly wrong");
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
