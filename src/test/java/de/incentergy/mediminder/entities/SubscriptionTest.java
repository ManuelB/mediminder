package de.incentergy.mediminder.entities;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SubscriptionTest {
	
	@BeforeClass
	public static void addBouncyCastle() {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
	}
	
	@AfterClass
	public static void removeBouncyCastle() {
		Security.removeProvider(BouncyCastleProvider.PROVIDER_NAME);
	}

	@Test
	public void testGetUserPublicKey() throws JsonParseException, JsonMappingException, IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException {
		ObjectMapper objectMapper = new ObjectMapper();
		Subscription subscription= objectMapper.readValue(
				new File("src/test/resources/resources/subscription/post.json"),
				Subscription.class);
		PublicKey publicKey = subscription.getUserPublicKey();
		assertNotNull(publicKey);
		
	}

}
