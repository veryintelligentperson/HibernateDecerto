package pl.decerto.techflash;

import org.hibernate.Session;
import pl.decerto.techflash.utils.HibernateUtil;
import pl.decerto.techflash.utils.InstanceUtils;

public class App {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.getTransaction().begin();

			session.save(InstanceUtils.getAccount("Michal", "Kowalski", "Warszawa"));

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			//HibernateUtil.getSessionFactory().close();
		}
	}


}
