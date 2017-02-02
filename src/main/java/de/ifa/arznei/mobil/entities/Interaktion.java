package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Interaktion" database table.
 * 
 */
@Entity
@Table(name="Interaktion")
@NamedQuery(name="Interaktion.findAll", query="SELECT i FROM Interaktion i")
public class Interaktion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private int id;

	@Column(name="Bezeichnung")
	private String bezeichnung;

	private int schweregrad;

	public Interaktion() {
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

	public int getSchweregrad() {
		return this.schweregrad;
	}

	public void setSchweregrad(int schweregrad) {
		this.schweregrad = schweregrad;
	}

}