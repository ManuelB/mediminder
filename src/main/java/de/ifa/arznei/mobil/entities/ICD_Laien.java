package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "ICD_Laien" database table.
 * 
 */
@Entity
@Table(name="ICD_Laien")
@NamedQuery(name="ICD_Laien.findAll", query="SELECT i FROM ICD_Laien i")
public class ICD_Laien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="Bezeichnung")
	private String bezeichnung;

	@Id
	private String icd;

	public ICD_Laien() {
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