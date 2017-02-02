package de.ifa.arznei.mobil.entities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;

public abstract class AbstractDatabaseTest extends TestWithLogging {

	private static final Logger log = Logger.getLogger(AbstractDatabaseTest.class.getName());

	private static EntityManager em;

	@Before
	public void before() throws IOException {

		Properties props = new Properties();
		InputStream is = ClassLoader.getSystemResourceAsStream("arznei-mobil-hibernate.properties");
		props.load(is);

		EntityManagerFactory fac = Persistence.createEntityManagerFactory("arznei-mobil", props);

		setEntityManager(fac.createEntityManager(props));
		getEntityManager().getTransaction().begin();
	}

	@After
	public void after() {
		getEntityManager().getTransaction().commit();
		getEntityManager().unwrap(Session.class).getSessionFactory().getStatistics().logSummary();
		getEntityManager().close();
	}

	/**
	 * @return the em
	 */
	public static EntityManager getEntityManager() {
		return em;
	}

	/**
	 * @param em
	 *            the em to set
	 */
	public static void setEntityManager(EntityManager em) {
		AbstractDatabaseTest.em = em;
	}
}
