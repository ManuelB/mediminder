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
	@Column(name = "Produkt_ID")
	private int produktId;
	@Id
	@Column(name = "Wirkstoff_ID")
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + produktId;
		result = prime * result + wirkstoffId;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produkt_WirkstoffPK other = (Produkt_WirkstoffPK) obj;
		if (produktId != other.produktId)
			return false;
		if (wirkstoffId != other.wirkstoffId)
			return false;
		return true;
	}
}
