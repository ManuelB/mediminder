package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Kontakte" database table.
 * 
 */
@Entity
@Table(name="Kontakte")
@NamedQuery(name="Kontakte.findAll", query="SELECT k FROM Kontakte k")
public class Kontakte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private int id;

	private String beschreibung;

	private String email;

	private String fax;

	@Column(name="KONTAKTE_TYP")
	private String kontakteTyp;

	private String ort;

	private String tel;

	private String url;

	public Kontakte() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBeschreibung() {
		return this.beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getKontakteTyp() {
		return this.kontakteTyp;
	}

	public void setKontakteTyp(String kontakteTyp) {
		this.kontakteTyp = kontakteTyp;
	}

	public String getOrt() {
		return this.ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}