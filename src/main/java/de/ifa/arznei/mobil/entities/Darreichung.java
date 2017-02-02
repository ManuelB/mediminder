package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Darreichung" database table.
 * 
 */
@Entity
@Table(name="Darreichung")
@NamedQuery(name="Darreichung.findAll", query="SELECT d FROM Darreichung d")
public class Darreichung implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private String id;

	@Column(name="Bezeichnung")
	private String bezeichnung;

	//bi-directional many-to-one association to Produkt
	@OneToMany(mappedBy="darreichung")
	private List<Produkt> produkts;

	public Darreichung() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBezeichnung() {
		return this.bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public List<Produkt> getProdukts() {
		return this.produkts;
	}

	public void setProdukts(List<Produkt> produkts) {
		this.produkts = produkts;
	}

	public Produkt addProdukt(Produkt produkt) {
		getProdukts().add(produkt);
		produkt.setDarreichung(this);

		return produkt;
	}

	public Produkt removeProdukt(Produkt produkt) {
		getProdukts().remove(produkt);
		produkt.setDarreichung(null);

		return produkt;
	}

}