package pl.decerto.techflash.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import pl.decerto.techflash.entities.Car;
import pl.decerto.techflash.entities.CompanyAccount;
import pl.decerto.techflash.entities.Credential;
import pl.decerto.techflash.entities.Transaction;
import pl.decerto.techflash.entities.User;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Credential.class);
			configuration.addAnnotatedClass(Transaction.class);
			configuration.addAnnotatedClass(CompanyAccount.class);
			configuration.addAnnotatedClass(Car.class);
		//	configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");
			return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Something went terribly wrong");
		}
	}

	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
