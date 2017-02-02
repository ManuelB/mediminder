package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the "Produkt" database table.
 * 
 */
@Entity
@Table(name = "Produkt")
@NamedQuery(name = "Produkt.findAll", query = "SELECT p FROM Produkt p")
public class Produkt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id")
	private int id;

	@Column(name = "Bezeichnung")
	private String bezeichnung;

	@Column(name = "Online")
	private int online;

	@Column(name = "Zusammensetzung_String")
	private String zusammensetzung_String;

	@OneToMany(mappedBy = "produkt")
	private List<Produkt_Wirkstoff> wirkstoffe;

	@ManyToOne(optional=true, fetch=FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "ATC", referencedColumnName = "_id") })
	private Atc atc;

	@ManyToOne(optional=true, fetch=FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "Darreichung_ID", referencedColumnName = "_id") })
	private Darreichung darreichung;

	@OneToMany(mappedBy = "produkt")
	private List<Artikel> artikel;

	@OneToMany(mappedBy = "produkt")
	private List<Produkt_Interaktion> produktInteraktions;

	public Produkt() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBezeichnung() {
		return this.bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public int getOnline() {
		return this.online;
	}

	public void setOnline(int online) {
		this.online = online;
	}

	public String getZusammensetzung_String() {
		return this.zusammensetzung_String;
	}

	public void setZusammensetzung_String(String zusammensetzung_String) {
		this.zusammensetzung_String = zusammensetzung_String;
	}

	public List<Produkt_Wirkstoff> getWirkstoffe() {
		return wirkstoffe;
	}

	public void setWirkstoffe(List<Produkt_Wirkstoff> wirkstoffe) {
		this.wirkstoffe = wirkstoffe;
	}

	public List<Artikel> getArtikel() {
		return artikel;
	}

	public void setArtikel(List<Artikel> artikel) {
		this.artikel = artikel;
	}

	public Atc getAtc() {
		return atc;
	}

	public void setAtc(Atc atc) {
		this.atc = atc;
	}

	public Darreichung getDarreichung() {
		return darreichung;
	}

	public void setDarreichung(Darreichung darreichung) {
		this.darreichung = darreichung;
	}

}