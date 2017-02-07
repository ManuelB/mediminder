package de.ifa.arznei.mobil.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class Produkt_WirkstoffPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7119488550460330450L;
	@Id
	@Column(name="Produkt_ID")
	private int produktId;
	@Id
	@Column(name="Wirkstoff_ID")
	private int wirkstoffId;

	public int getProdukt() {
		return produktId;
	}
	public void setProdukt(int produktId) {
		this.produktId = produktId;
	}
	public int getWirkstoff() {
		return wirkstoffId;
	}
	public void setWirkstoff(int wirkstoffId) {
		this.wirkstoffId = wirkstoffId;
	}
}
