package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Status" database table.
 * 
 */
@Entity
@Table(name="Status")
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="ARTIKEL_ZAHL")
	private int artikelZahl;

	@Id
	private String datenstand;

	@Column(name="WIRKSTOFF_ZAHL")
	private int wirkstoffZahl;

	public Status() {
	}

	public int getArtikelZahl() {
		return this.artikelZahl;
	}

	public void setArtikelZahl(int artikelZahl) {
		this.artikelZahl = artikelZahl;
	}

	public String getDatenstand() {
		return this.datenstand;
	}

	public void setDatenstand(String datenstand) {
		this.datenstand = datenstand;
	}

	public int getWirkstoffZahl() {
		return this.wirkstoffZahl;
	}

	public void setWirkstoffZahl(int wirkstoffZahl) {
		this.wirkstoffZahl = wirkstoffZahl;
	}

}