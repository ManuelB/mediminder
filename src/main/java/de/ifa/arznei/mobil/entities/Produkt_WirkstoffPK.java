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
	private int produkt;
	@Id
	@Column(name="Wirkstoff_ID")
	private int wirkstoff;

	public int getProdukt() {
		return produkt;
	}
	public void setProdukt(int produkt) {
		this.produkt = produkt;
	}
	public int getWirkstoff() {
		return wirkstoff;
	}
	public void setWirkstoff(int wirkstoff) {
		this.wirkstoff = wirkstoff;
	}
}
