package de.incentergy.mediminder.entities;

import java.util.UUID;

import javax.ejb.TimerHandle;
import javax.json.JsonObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "RegularNotification.findBySubscriptionKeyTimeMedicineQuantityUnit", query = "SELECT rn FROM RegularNotification rn WHERE rn.subscription.key = :subscriptionKey AND rn.time = :time AND rn.medicine = :medicine AND rn.quantity = :quantity AND rn.unit = :unit") })
public class RegularNotification {
	@Id
	private String id;

	private String time;
	private String medicine;
	private Double quantity;
	private String unit;
	/* Value too long for column "TIMERHANDLE BINARY(255)": "X'aced00057372002e6f72672e6a626f73732e61732e656a62332e74696d6572736572766963652e54696d657248616e646c65496d706c000000000000000102... (299)"; SQL statement: */ 
	@Column(length=4096)
	private TimerHandle timerHandle;

	@ManyToOne()
	private Subscription subscription;

	public RegularNotification() {

	}

	public RegularNotification(String medicine, JsonObject jsonObject) {
		setId(UUID.randomUUID().toString());
		setMedicine(medicine);
		setTime(jsonObject.getString("time").toLowerCase());
		setQuantity(jsonObject.getJsonNumber("quantity").doubleValue());
		setUnit(jsonObject.getString("unit"));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public TimerHandle getTimerHandle() {
		return timerHandle;
	}

	public void setTimerHandle(TimerHandle timerHandle) {
		this.timerHandle = timerHandle;
	}

}
