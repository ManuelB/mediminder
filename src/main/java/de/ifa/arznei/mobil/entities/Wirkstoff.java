package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "Wirkstoff" database table.
 * 
 */
@Entity
@Table(name="Wirkstoff")
@NamedQuery(name="Wirkstoff.findAll", query="SELECT w FROM Wirkstoff w")
public class Wirkstoff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private int id;

	@Column(name="Bezeichnung")
	private String bezeichnung;
	
	@OneToMany(mappedBy="wirkstoff")
	private List<Produkt_Wirkstoff> produktWirkstoff;

	public Wirkstoff() {
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

	public List<Produkt_Wirkstoff> getProduktWirkstoff() {
		return produktWirkstoff;
	}

	public void setProduktWirkstoff(List<Produkt_Wirkstoff> produktWirkstoff) {
		this.produktWirkstoff = produktWirkstoff;
	}


}