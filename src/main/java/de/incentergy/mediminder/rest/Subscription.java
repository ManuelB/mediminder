package de.incentergy.mediminder.rest;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.jose4j.lang.JoseException;

import nl.martijndwars.webpush.Notification;
import nl.martijndwars.webpush.PushService;

@Stateless
@Path("subscription")
public class Subscription {

	private static final Logger log = Logger.getLogger(Subscription.class.getName());

	@PersistenceContext(unitName = "mediminder")
	EntityManager em;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void post(de.incentergy.mediminder.entities.Subscription subscription) {
		if (subscription == null) {
			return;
		}
		log.info("Creating subscription: " + subscription.getKey());
		em.merge(subscription);
	}

	/**
	 * curl -X POST --data "Jo Digga"
	 * http://localhost:8080/mediminder/resources/subscription/BC14K9LHlij0/fYNFTMheDYSBK+kBttPal8Cwnfp3/0KkRkg0OlasLZqQcd58hWp86Mo4NN1OBwwlH/Dpu0ciQ0=/send
	 * 
	 * curl -X POST --data "Jo Digga"
	 * http://localhost:8080/mediminder/resources/subscription/BNuxXaLiJf9prZ2ku6822ufyLIEk0lKOjV79dETfYDYwLqgG9BN7oQrAQjlHcLP5RGF9LR9B0sRnL9CLROYVgqs=/send
	 *
	 * @param key
	 * @param payloadString
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchProviderException
	 * @throws InvalidKeyException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IOException
	 * @throws JoseException
	 */
	@POST
	// http://stackoverflow.com/questions/2291428/jax-rs-pathparam-how-to-pass-a-string-with-slashes-hyphens-equals-too
	@Path("/{key : .+}/send")
	public void send(@PathParam("key") String key, String payloadString)
			throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException, InvalidKeyException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException,
			IOException, JoseException {

		de.incentergy.mediminder.entities.Subscription subscription = em
				.find(de.incentergy.mediminder.entities.Subscription.class, key);
		byte[] payload = payloadString.getBytes();
		// Figure out if we should use GCM for this notification somehow
		Notification notification;
		PushService pushService;
		// http://stackoverflow.com/questions/36252742/wildfly-10-bouncycastlecrypto-ecdsa-key-spec-not-recognized
		// Aktuelles Problem:
		// http://stackoverflow.com/questions/29700288/bouncycastle-1-51-loading-in-war-on-wildfly-8-0

		// Create a notification with the endpoint, userPublicKey from the
		// subscription and a custom payload
		notification = new Notification(subscription.getEndpoint(), subscription.getUserPublicKey(),
				subscription.getAuthAsBytes(), payload);

		Properties properties = new Properties();
		properties.load(getClass().getResourceAsStream("/mediminder.properties"));

		// Instantiate the push service, no need to use an API key for Push
		// API
		pushService = new PushService();
		String gcmapikey = properties.getProperty("mediminder.gcmapikey");
		if (gcmapikey == null) {
			log.warning("mediminder.gcmapikey not set in mediminder.properties. Please create file in: "
					+ getClass().getResource("/") + " and set property 'mediminder.gcmapikey'. You get it from e.g. here: https://console.firebase.google.com/project/www-mediminder-de/settings/cloudmessaging");
			return;
		}
		pushService.setGcmApiKey(gcmapikey);

		// Send the notification
		pushService.send(notification);
	}
}
