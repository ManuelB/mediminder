package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Interaktion_Text_Typ" database table.
 * 
 */
@Entity
@Table(name="Interaktion_Text_Typ")
@NamedQuery(name="Interaktion_Text_Typ.findAll", query="SELECT i FROM Interaktion_Text_Typ i")
public class Interaktion_Text_Typ implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private int id;

	private String beschreibung;

	public Interaktion_Text_Typ() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBeschreibung() {
		return this.beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

}