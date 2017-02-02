package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "TextTyp" database table.
 * 
 */
@Entity
@Table(name="TextTyp")
@NamedQuery(name="TextTyp.findAll", query="SELECT t FROM TextTyp t")
public class TextTyp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private int id;

	@Column(name="Bezeichnung")
	private String bezeichnung;

	//bi-directional many-to-one association to Produkt_Text
	@OneToMany(mappedBy="textTyp")
	private List<Produkt_Text> produktTexts;

	public TextTyp() {
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

	public List<Produkt_Text> getProduktTexts() {
		return this.produktTexts;
	}

	public void setProduktTexts(List<Produkt_Text> produktTexts) {
		this.produktTexts = produktTexts;
	}

	public Produkt_Text addProduktText(Produkt_Text produktText) {
		getProduktTexts().add(produktText);
		produktText.setTextTyp(this);

		return produktText;
	}

	public Produkt_Text removeProduktText(Produkt_Text produktText) {
		getProduktTexts().remove(produktText);
		produktText.setTextTyp(null);

		return produktText;
	}

}