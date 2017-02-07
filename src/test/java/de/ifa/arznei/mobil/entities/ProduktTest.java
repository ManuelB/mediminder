package de.ifa.arznei.mobil.entities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

public class ProduktTest extends AbstractDatabaseTest {

	@Test
	public void testGetProduktMitWirkstoff() throws IOException {
		EntityManager em = getEntityManager();
		List<String> wirkstoffe = Arrays.asList("Ibuprofen", "Levothyroxin, Natriumsalz", "Metoprolol succinat",
				"Diclofenac, Natriumsalz", "Ramipril", "Simvastatin", "Metamizol Natrium 1-Wasser", "Omeprazol",
				"Bisoprolol hemifumarat", "Pantoprazol Natrium 1,5-Wasser");

		Files.createDirectory(Paths.get("src/test/resources/Texte"));
		
		for (String wirkstoff : wirkstoffe) {
			List<Produkt> produkte = em.createNamedQuery("Produkt.findByWirkstoff", Produkt.class)
					.setParameter("wirkstoff", wirkstoff).setMaxResults(1).getResultList();
			for (Produkt produkt : produkte) {
				produkt.getProduktTexte().stream().filter((t) -> "Dosierung".equals(t.getTextTyp().getBezeichnung()))
						.forEach((t) -> {
							try {
								Files.write(Paths.get("src/test/resources/Texte/" + t.getTexte().getId() + ".html"),
										("<html><head></head><body>"+t.getTexte().getText_Data()+"</body></html>").getBytes());
							} catch (IOException e) {
								e.printStackTrace();
							}
						});
			}
		}
	}

}
