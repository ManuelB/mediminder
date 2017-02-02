package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "ICD_Synonym" database table.
 * 
 */
@Entity
@Table(name="ICD_Synonym")
@NamedQuery(name="ICD_Synonym.findAll", query="SELECT i FROM ICD_Synonym i")
public class ICD_Synonym implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="Bezeichnung")
	private String bezeichnung;

	@Id
	private String icd;

	public ICD_Synonym() {
	}

	public String getBezeichnung() {
		return this.bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getIcd() {
		return this.icd;
	}

	public void setIcd(String icd) {
		this.icd = icd;
	}

}