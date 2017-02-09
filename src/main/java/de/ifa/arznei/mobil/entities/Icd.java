package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the ICD database table.
 * 
 */
@Entity
@NamedQuery(name="Icd.findAll", query="SELECT i FROM Icd i")
public class Icd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private String id;

	@Column(name="Bezeichnung")
	private String bezeichnung;

	@Column(name="Parent_ICD")
	private String parent_ICD;
	
	@ManyToMany(mappedBy="icds")
	private List<Atc> atcs;

	public Icd() {
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

	public String getParent_ICD() {
		return this.parent_ICD;
	}

	public void setParent_ICD(String parent_ICD) {
		this.parent_ICD = parent_ICD;
	}

	/**
	 * @return the atcs
	 */
	public List<Atc> getAtcs() {
		return atcs;
	}

	/**
	 * @param atcs the atcs to set
	 */
	public void setAtcs(List<Atc> atcs) {
		this.atcs = atcs;
	}

}