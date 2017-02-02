package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ICD_ATC database table.
 * 
 */
@Entity
@Table(name="ICD_ATC")
@NamedQuery(name="IcdAtc.findAll", query="SELECT i FROM IcdAtc i")
public class IcdAtc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String atc;

	@Id
	private String icd;

	public IcdAtc() {
	}

	public String getAtc() {
		return this.atc;
	}

	public void setAtc(String atc) {
		this.atc = atc;
	}

	public String getIcd() {
		return this.icd;
	}

	public void setIcd(String icd) {
		this.icd = icd;
	}

}