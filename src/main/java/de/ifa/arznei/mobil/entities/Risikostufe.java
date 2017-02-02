package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Risikostufe" database table.
 * 
 */
@Entity
@Table(name="Risikostufe")
@NamedQuery(name="Risikostufe.findAll", query="SELECT r FROM Risikostufe r")
public class Risikostufe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private int id;

	@Column(name="Farbe")
	private String farbe;

	public Risikostufe() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFarbe() {
		return this.farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

}