package pl.decerto.techflash;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import pl.decerto.techflash.utils.HibernateUtil;

public class App {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
	}

}
