package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Hersteller" database table.
 * 
 */
@Entity
@Table(name="Hersteller")
@NamedQuery(name="Hersteller.findAll", query="SELECT h FROM Hersteller h")
public class Hersteller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private int id;

	@Column(name="Email")
	private String email;

	@Column(name="Fax")
	private String fax;

	@Column(name="Firmenname")
	private String firmenname;

	@Column(name="Haus_Nr")
	private String haus_Nr;

	@Column(name="Land")
	private String land;

	@Column(name="Ort")
	private String ort;

	@Column(name="Phone")
	private String phone;

	private String plz;

	@Column(name="Strasse")
	private String strasse;

	private String url;

	public Hersteller() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFirmenname() {
		return this.firmenname;
	}

	public void setFirmenname(String firmenname) {
		this.firmenname = firmenname;
	}

	public String getHaus_Nr() {
		return this.haus_Nr;
	}

	public void setHaus_Nr(String haus_Nr) {
		this.haus_Nr = haus_Nr;
	}

	public String getLand() {
		return this.land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public String getOrt() {
		return this.ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPlz() {
		return this.plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getStrasse() {
		return this.strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}