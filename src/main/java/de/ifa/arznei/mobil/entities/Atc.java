package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the ATC database table.
 * 
 */
@Entity
@NamedQuery(name = "Atc.findAll", query = "SELECT a FROM Atc a")
public class Atc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id")
	private String id;

	@Column(name = "Bezeichnung")
	private String bezeichnung;

	// bi-directional many-to-one association to Atc
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumns({ @JoinColumn(name = "Parent_ATC", referencedColumnName = "_id") })
	private Atc atc;

	// bi-directional many-to-one association to Atc
	@OneToMany(mappedBy = "atc", fetch=FetchType.LAZY)
	private List<Atc> atcs;

	// bi-directional many-to-one association to Produkt
	@OneToMany(mappedBy = "atc")
	private List<Produkt> produkts;

	public Atc() {
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

	public Atc getAtc() {
		return this.atc;
	}

	public void setAtc(Atc atc) {
		this.atc = atc;
	}

	public List<Atc> getAtcs() {
		return this.atcs;
	}

	public void setAtcs(List<Atc> atcs) {
		this.atcs = atcs;
	}

	public Atc addAtc(Atc atc) {
		getAtcs().add(atc);
		atc.setAtc(this);

		return atc;
	}

	public Atc removeAtc(Atc atc) {
		getAtcs().remove(atc);
		atc.setAtc(null);

		return atc;
	}

	public List<Produkt> getProdukts() {
		return this.produkts;
	}

	public void setProdukts(List<Produkt> produkts) {
		this.produkts = produkts;
	}

}