package de.ifa.arznei.mobil.entities;

import java.io.IOException;
import java.util.logging.LogManager;

import org.junit.BeforeClass;

/**
 * Enables the reading of the logging.properties file
 * in src/test/resources/logging.properties
 * @author manuel
 *
 */
public class TestWithLogging {
	@BeforeClass
	public static void configureLogging() {
		try {
			// https://community.oracle.com/thread/1307033?start=0&tstart=0
			LogManager.getLogManager().readConfiguration(
					TestWithLogging.class
							.getResourceAsStream("/logging.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}