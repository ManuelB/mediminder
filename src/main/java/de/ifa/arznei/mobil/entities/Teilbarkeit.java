package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "teilbarkeit" database table.
 * 
 */
@Entity
@Table(name="teilbarkeit")
@NamedQuery(name="Teilbarkeit.findAll", query="SELECT t FROM Teilbarkeit t")
public class Teilbarkeit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int teilbarkeit;

	@Column(name="TEILBARKEIT_BEZEICHNUNG")
	private String teilbarkeitBezeichnung;

	public Teilbarkeit() {
	}

	public int getTeilbarkeit() {
		return this.teilbarkeit;
	}

	public void setTeilbarkeit(int teilbarkeit) {
		this.teilbarkeit = teilbarkeit;
	}

	public String getTeilbarkeitBezeichnung() {
		return this.teilbarkeitBezeichnung;
	}

	public void setTeilbarkeitBezeichnung(String teilbarkeitBezeichnung) {
		this.teilbarkeitBezeichnung = teilbarkeitBezeichnung;
	}

}