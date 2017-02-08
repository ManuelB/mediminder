package de.incentergy.mediminder.rest;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.ejb.ScheduleExpression;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerHandle;
import javax.ejb.TimerService;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.jose4j.lang.JoseException;

import de.incentergy.mediminder.entities.RegularNotification;
import de.incentergy.mediminder.entities.Subscription;

@Stateless
@Path("reduxServerStore")
public class ReduxServerStore {

	@Inject
	de.incentergy.mediminder.rest.Subscription subscriptionService;

	@Resource
	TimerService timerService;

	private static final Logger log = Logger.getLogger(ReduxServerStore.class.getName());

	@PersistenceContext(unitName = "mediminder")
	EntityManager em;

	@POST
	@Path("/ADD_MEDICINE")
	@Consumes(MediaType.APPLICATION_JSON)
	public void ADD_MEDICINE(JsonObject jsonObject) {
		String notificationSubscriptionKey = jsonObject.getString("notificationSubscriptionKey");
		Subscription subscription = em.find(Subscription.class, notificationSubscriptionKey);
		// "medicationSchedule": {
		// "dailySchedules": [{
		// "time": "8:00 PM",
		// "quantity": 1,
		// "unit": "C62"
		// }],
		// "endDateDisabled": true,
		// "endDate": "2017-02-07T16:13:58.887Z"
		// }
		for (JsonValue dailyScheduleValue : jsonObject.getJsonObject("medicine").getJsonObject("medicationSchedule")
				.getJsonArray("dailySchedules")) {
			JsonObject dailySchedule = (JsonObject) dailyScheduleValue;
			String medicine = jsonObject.getJsonObject("medicine").getJsonObject("article")
					.getJsonObject("ProduktDetails").getString("Bezeichnung");
			RegularNotification regularNotification = new RegularNotification(medicine, dailySchedule);
			regularNotification.setSubscription(subscription);

			String timeString = dailySchedule.getString("time");
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
			Date date;
			ScheduleExpression schedule = new ScheduleExpression();
			int hour = 20;
			int minute = 0;
			try {
				date = sdf.parse(timeString);
				Calendar calendar = GregorianCalendar.getInstance(); // creates
																		// a new
																		// calendar
																		// instance
				calendar.setTime(date); // assigns calendar to given date
				hour = calendar.get(Calendar.HOUR_OF_DAY);
				minute = calendar.get(Calendar.MINUTE);

				schedule.hour(hour);
				schedule.minute(minute);
			} catch (ParseException e) {
				log.warning("Could not parse: " + timeString + " default to 20:00");
			}

			TimerConfig timerConfig = new TimerConfig(regularNotification.getId(), true);
			Timer timer = timerService.createCalendarTimer(schedule, timerConfig);
			TimerHandle timerHandle = timer.getHandle();
			regularNotification.setTimerHandle(timerHandle);
			subscription.getRegularNotifications().add(regularNotification);
			em.persist(regularNotification);
		}

	}

	@POST
	@Path("/DELETE_MEDICINE")
	@Consumes(MediaType.APPLICATION_JSON)
	public void DELETE_MEDICINE(JsonObject jsonObject) {
		String notificationSubscriptionKey = jsonObject.getString("notificationSubscriptionKey");
		// "medicationSchedule": {
		// "dailySchedules": [{
		// "time": "8:00 PM",
		// "quantity": 1,
		// "unit": "C62"
		// }],
		// "endDateDisabled": true,
		// "endDate": "2017-02-07T16:13:58.887Z"
		// }
		for (JsonValue dailyScheduleValue : jsonObject.getJsonObject("medicine").getJsonObject("medicationSchedule")
				.getJsonArray("dailySchedules")) {
			JsonObject dailySchedule = (JsonObject) dailyScheduleValue;
			String medicine = jsonObject.getJsonObject("medicine").getJsonObject("article")
					.getJsonObject("ProduktDetails").getString("Bezeichnung");
			RegularNotification regularNotification = new RegularNotification(medicine, dailySchedule);
			RegularNotification regularNotificationFromDatabase = em
					.createNamedQuery("RegularNotification.findBySubscriptionKeyTimeMedicineQuantityUnit",
							RegularNotification.class)
					.setMaxResults(1).setParameter("subscriptionKey", notificationSubscriptionKey)
					.setParameter("time", regularNotification.getTime())
					.setParameter("medicine", regularNotification.getMedicine())
					.setParameter("quantity", regularNotification.getQuantity())
					.setParameter("unit", regularNotification.getUnit()).getSingleResult();
			regularNotificationFromDatabase.getTimerHandle().getTimer().cancel();
			regularNotificationFromDatabase.getSubscription().getRegularNotifications()
					.remove(regularNotificationFromDatabase);
			em.remove(regularNotificationFromDatabase);
		}
	}

	@GET
	@Path("/DELETE_ALL_TIMERS")
	public void DELETE_ALL_TIMERS() {
		timerService.getAllTimers().stream().forEach((t) -> t.cancel());
	}

	@Timeout
	public void sendNotification(Timer timer) {
		RegularNotification regularNotification = em.find(RegularNotification.class, timer.getInfo());
		try {
			subscriptionService.send(regularNotification.getSubscription().getKey(),
					"Bitte nehmen Sie von " + regularNotification.getMedicine() + " "
							+ NumberFormat.getInstance().format(regularNotification.getQuantity()) + " "
							+ ("C62".equals(regularNotification.getUnit()) ? "Stück" : regularNotification.getUnit()));
		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchProviderException
				| NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException
				| InvalidAlgorithmParameterException | IOException | JoseException e) {
			log.log(Level.WARNING, "Could not send regular notification: " + timer.getInfo(), e);
		}
	}

}
