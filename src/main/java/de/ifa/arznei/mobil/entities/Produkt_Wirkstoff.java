package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the "Produkt_Wirkstoff" database table.
 * 
 */
@Entity
@Table(name = "Produkt_Wirkstoff")
@IdClass(Produkt_WirkstoffPK.class)
@NamedQuery(name = "Produkt_Wirkstoff.findAll", query = "SELECT p FROM Produkt_Wirkstoff p")
public class Produkt_Wirkstoff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "Basiseinheit")
	private String basiseinheit;

	@Column(name = "Bemerkung")
	private String bemerkung;

	@Column(name = "Kombi_ID")
	private String kombi_ID;

	@Column(name = "Menge")
	private String menge;

	@Column(name = "Sort")
	private String sort;
	
	// bi-directional many-to-one association to Produkt
	@Id
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "Produkt_ID", referencedColumnName = "_id") })
	private Produkt produkt;

	// bi-directional one-to-one association to Wirkstoff
	@Id
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "Wirkstoff_ID", referencedColumnName = "_id") })
	private Wirkstoff wirkstoff;

	public Produkt_Wirkstoff() {
	}

	public String getBasiseinheit() {
		return this.basiseinheit;
	}

	public void setBasiseinheit(String basiseinheit) {
		this.basiseinheit = basiseinheit;
	}

	public String getBemerkung() {
		return this.bemerkung;
	}

	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}

	public String getKombi_ID() {
		return this.kombi_ID;
	}

	public void setKombi_ID(String kombi_ID) {
		this.kombi_ID = kombi_ID;
	}

	public String getMenge() {
		return this.menge;
	}

	public void setMenge(String menge) {
		this.menge = menge;
	}

	public String getSort() {
		return this.sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getWirkstoff_ID() {
		return this.wirkstoff_ID;
	}

	public void setWirkstoff_ID(int wirkstoff_ID) {
		this.wirkstoff_ID = wirkstoff_ID;
	}

	public Produkt getProdukt() {
		return this.produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

	public Wirkstoff getWirkstoff() {
		return this.wirkstoff;
	}

	public void setWirkstoff(Wirkstoff wirkstoff) {
		this.wirkstoff = wirkstoff;
	}

}