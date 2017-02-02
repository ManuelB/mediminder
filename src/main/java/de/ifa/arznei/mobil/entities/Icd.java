package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;


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

}