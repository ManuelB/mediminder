package de.incentergy.mediminder.rest;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.io.IOException;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SubscriptionTest {

	@Test
	public void testInit() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		de.incentergy.mediminder.entities.Subscription subscription= objectMapper.readValue(
				new File("src/test/resources/resources/subscription/post.json"),
				 de.incentergy.mediminder.entities.Subscription.class);
		Subscription subscriptionRest = new Subscription();
		subscriptionRest.em = mock(EntityManager.class);
		subscriptionRest.post(subscription);
		verify(subscriptionRest.em, times(1)).merge(anyObject());
	}

}
