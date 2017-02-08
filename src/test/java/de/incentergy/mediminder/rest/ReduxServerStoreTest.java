package de.incentergy.mediminder.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.ejb.ScheduleExpression;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerHandle;
import javax.ejb.TimerService;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import de.incentergy.mediminder.entities.RegularNotification;
import de.incentergy.mediminder.entities.Subscription;

public class ReduxServerStoreTest {

	@Test
	public void testADD_MEDICINE() throws FileNotFoundException {
		ReduxServerStore reduxServerStore = new ReduxServerStore();
		reduxServerStore.em = mock(EntityManager.class);
		reduxServerStore.timerService = mock(TimerService.class);
		when(reduxServerStore.em.find(eq(de.incentergy.mediminder.entities.Subscription.class), anyString()))
				.thenReturn(new de.incentergy.mediminder.entities.Subscription());
		when(reduxServerStore.timerService.createCalendarTimer(any(ScheduleExpression.class), any(TimerConfig.class)))
				.thenReturn(mock(Timer.class));
		JsonObject jsonObject = (JsonObject) Json
				.createReader(new FileReader("src/test/resources/resources/reduxServerStore/ADD_MEDICINE/post.json"))
				.read();
		reduxServerStore.ADD_MEDICINE(jsonObject);
	}

	@Test
	public void testADD_MEDICINE_12_29_PM() throws FileNotFoundException {
		ReduxServerStore reduxServerStore = new ReduxServerStore();
		reduxServerStore.em = mock(EntityManager.class);
		reduxServerStore.timerService = mock(TimerService.class);
		when(reduxServerStore.em.find(eq(de.incentergy.mediminder.entities.Subscription.class), anyString()))
				.thenReturn(new de.incentergy.mediminder.entities.Subscription());
		when(reduxServerStore.timerService.createCalendarTimer(any(ScheduleExpression.class), any(TimerConfig.class)))
				.thenReturn(mock(Timer.class));
		JsonObject jsonObject = (JsonObject) Json
				.createReader(new FileReader("src/test/resources/resources/reduxServerStore/ADD_MEDICINE/post_2.json"))
				.read();
		reduxServerStore.ADD_MEDICINE(jsonObject);

		ArgumentCaptor<ScheduleExpression> argumentCaptor = ArgumentCaptor.forClass(ScheduleExpression.class);
		verify(reduxServerStore.timerService).createCalendarTimer(argumentCaptor.capture(), any(TimerConfig.class));

		ScheduleExpression scheduleExpression = argumentCaptor.getValue();
		assertEquals("12", scheduleExpression.getHour());
		assertEquals("29", scheduleExpression.getMinute());
	}

	@Test
	public void testDELETE_MEDICINE() throws FileNotFoundException {
		ReduxServerStore reduxServerStore = new ReduxServerStore();
		reduxServerStore.em = mock(EntityManager.class);
		TypedQuery<RegularNotification> typedQuery = mock(TypedQuery.class);
		when(typedQuery.setMaxResults(anyInt())).thenReturn(typedQuery);
		when(typedQuery.setParameter(anyString(), anyObject())).thenReturn(typedQuery);
		RegularNotification regularNotification = new RegularNotification();
		regularNotification.setSubscription(new Subscription());
		TimerHandle timerHandle = mock(TimerHandle.class);
		when(timerHandle.getTimer()).thenReturn(mock(Timer.class));
		regularNotification.setTimerHandle(timerHandle);
		when(typedQuery.getSingleResult()).thenReturn(regularNotification);
		when(reduxServerStore.em.createNamedQuery(
				eq("RegularNotification.findBySubscriptionKeyTimeMedicineQuantityUnit"), eq(RegularNotification.class)))
						.thenReturn(typedQuery);
		JsonObject jsonObject = (JsonObject) Json
				.createReader(new FileReader("src/test/resources/resources/reduxServerStore/DELETE_MEDICINE/post.json"))
				.read();
		reduxServerStore.DELETE_MEDICINE(jsonObject);
	}

}
