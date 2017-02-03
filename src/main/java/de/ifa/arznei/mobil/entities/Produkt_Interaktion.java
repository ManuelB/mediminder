package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the "Produkt_Interaktion" database table.
 * 
 */
@Entity
@Table(name="Produkt_Interaktion")
@NamedQuery(name="Produkt_Interaktion.findAll", query="SELECT p FROM Produkt_Interaktion p")
public class Produkt_Interaktion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id")
	private int id;
	
	@Column(name="Seite")
	private String seite;

	//bi-directional many-to-many association to Produkt
	@ManyToOne()
	@JoinColumns({ @JoinColumn(name = "_id", referencedColumnName = "_id", insertable = false, updatable = false) })
	private Produkt produkt;
	
	@ManyToOne()
	@JoinColumns({ @JoinColumn(name = "Interaktion_ID", referencedColumnName = "_id") })
	private Interaktion interaktion;

	public Produkt_Interaktion() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Interaktion getInteraktion() {
		return this.interaktion;
	}

	public void setInteraktion_ID(Interaktion interaktion) {
		this.interaktion = interaktion;
	}

	public String getSeite() {
		return this.seite;
	}

	public void setSeite(String seite) {
		this.seite = seite;
	}

	public Produkt getProdukt() {
		return this.produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

}