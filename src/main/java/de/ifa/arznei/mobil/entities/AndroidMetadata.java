package de.ifa.arznei.mobil.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the "android_metadata" database table.
 * 
 */
@Entity
@Table(name="android_metadata")
@NamedQuery(name="AndroidMetadata.findAll", query="SELECT a FROM AndroidMetadata a")
public class AndroidMetadata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="locale")
	private String locale;

	public AndroidMetadata() {
	}

	public String getLocale() {
		return this.locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

}