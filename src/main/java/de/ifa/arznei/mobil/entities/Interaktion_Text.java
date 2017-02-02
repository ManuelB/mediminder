package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Interaktion_Text" database table.
 * 
 */
@Entity
@Table(name="Interaktion_Text")
@NamedQuery(name="Interaktion_Text.findAll", query="SELECT i FROM Interaktion_Text i")
public class Interaktion_Text implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private int id;

	private String data;

	@Column(name="INTERAKTION_TEXT_TYP_ID")
	private int interaktionTextTypId;

	public Interaktion_Text() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getInteraktionTextTypId() {
		return this.interaktionTextTypId;
	}

	public void setInteraktionTextTypId(int interaktionTextTypId) {
		this.interaktionTextTypId = interaktionTextTypId;
	}

}