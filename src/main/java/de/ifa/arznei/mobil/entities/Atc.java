package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

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
	
	@ManyToMany
	@JoinTable(
		      name="ICD_ATC",
		      joinColumns=@JoinColumn(name="ATC", referencedColumnName="_id"),
		      inverseJoinColumns=@JoinColumn(name="ICD", referencedColumnName="_id"))
	private List<Icd> icds;

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

	/**
	 * @return the icds
	 */
	public List<Icd> getIcds() {
		return icds;
	}

	/**
	 * @param icds the icds to set
	 */
	public void setIcds(List<Icd> icds) {
		this.icds = icds;
	}

}