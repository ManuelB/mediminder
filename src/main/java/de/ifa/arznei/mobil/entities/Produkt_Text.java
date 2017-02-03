package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the "Produkt_Text" database table.
 * 
 */
@Entity
@Table(name = "Produkt_Text")
@NamedQuery(name = "Produkt_Text.findAll", query = "SELECT p FROM Produkt_Text p")
public class Produkt_Text implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "Schweregrad")
	private String schweregrad;

	@Id
	@Column(name = "Text_ID")
	private int text_ID;

	// bi-directional many-to-one association to Produkt
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "Produkt_ID", referencedColumnName = "_id") })
	private Produkt produkt;

	// bi-directional many-to-one association to TextTyp
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "TextTyp_ID", referencedColumnName = "_id") })
	private TextTyp textTyp;

	// bi-directional one-to-one association to Texte
	@OneToOne
	@JoinColumns({ @JoinColumn(name = "Text_ID", referencedColumnName = "_id", updatable=false, insertable=false) })
	private Texte texte;

	public Produkt_Text() {
	}

	public String getSchweregrad() {
		return this.schweregrad;
	}

	public void setSchweregrad(String schweregrad) {
		this.schweregrad = schweregrad;
	}

	public int getText_ID() {
		return this.text_ID;
	}

	public void setText_ID(int text_ID) {
		this.text_ID = text_ID;
	}

	public Produkt getProdukt() {
		return this.produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

	public TextTyp getTextTyp() {
		return this.textTyp;
	}

	public void setTextTyp(TextTyp textTyp) {
		this.textTyp = textTyp;
	}

	public Texte getTexte() {
		return this.texte;
	}

	public void setTexte(Texte texte) {
		this.texte = texte;
	}

}