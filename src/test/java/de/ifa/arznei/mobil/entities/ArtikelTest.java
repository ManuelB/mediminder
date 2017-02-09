package de.ifa.arznei.mobil.entities;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Ignore;
import org.junit.Test;

public class ArtikelTest extends AbstractDatabaseTest {

	@Test
	@Ignore
	public void testGetId() {
		EntityManager em = getEntityManager();
		List<Artikel> artikelList = em.createNamedQuery("Artikel.findAll", Artikel.class).getResultList();
		for (Artikel artikel : artikelList) {
			System.out.println(artikel);
		}
	}

}
