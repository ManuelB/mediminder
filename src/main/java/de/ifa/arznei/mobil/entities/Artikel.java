package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the "Artikel" database table.
 * 
 */
@Entity
@Table(name = "Artikel")
@NamedQuery(name = "Artikel.findAll", query = "SELECT a FROM Artikel a")
public class Artikel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id")
	private int id;

	@Column(name = "Aenderungsdatum")
	private String aenderungsdatum;

	private BigDecimal avp;

	@Column(name = "Hinweise")
	private String hinweise;

	@Column(name = "Menge")
	private String menge;

	@Column(name = "Neuerscheinung")
	private int neuerscheinung;

	@Column(name = "Norm")
	private String norm;

	private int pvgl;

	@Column(name = "Sortiment_Diaetetika")
	private String sortiment_Diaetetika;

	@Column(name = "Sortiment_Diagnostika")
	private String sortiment_Diagnostika;

	@Column(name = "Sortiment_Enterale_Ernaehrung")
	private String sortiment_Enterale_Ernaehrung;

	@Column(name = "Sortiment_Hilfsmittel")
	private String sortiment_Hilfsmittel;

	@Column(name = "Sortiment_Homoeopathika")
	private String sortiment_Homoeopathika;

	@Column(name = "Sortiment_IFAP")
	private String sortiment_IFAP;

	@Column(name = "Sortiment_KlinikArznei")
	private String sortiment_KlinikArznei;

	@Column(name = "Sortiment_Schwangerschaftstest")
	private String sortiment_Schwangerschaftstest;

	@Column(name = "Sortiment_Teststreifen")
	private String sortiment_Teststreifen;

	@Column(name = "Sortiment_Tierarzneimittel")
	private int sortiment_Tierarzneimittel;

	@Column(name = "Sortiment_Verbandmittel")
	private String sortiment_Verbandmittel;

	@Column(name = "Teilbarkeit")
	private String teilbarkeit;

	@Column(name = "Zuzahlung")
	private BigDecimal zuzahlung;

	// bi-directional many-to-one association to Produkt
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "Produkt_ID", referencedColumnName = "_id") })
	private Produkt produkt;

	public Artikel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAenderungsdatum() {
		return this.aenderungsdatum;
	}

	public void setAenderungsdatum(String aenderungsdatum) {
		this.aenderungsdatum = aenderungsdatum;
	}

	public BigDecimal getAvp() {
		return this.avp;
	}

	public void setAvp(BigDecimal avp) {
		this.avp = avp;
	}

	public String getHinweise() {
		return this.hinweise;
	}

	public void setHinweise(String hinweise) {
		this.hinweise = hinweise;
	}

	public String getMenge() {
		return this.menge;
	}

	public void setMenge(String menge) {
		this.menge = menge;
	}

	public int getNeuerscheinung() {
		return this.neuerscheinung;
	}

	public void setNeuerscheinung(int neuerscheinung) {
		this.neuerscheinung = neuerscheinung;
	}

	public String getNorm() {
		return this.norm;
	}

	public void setNorm(String norm) {
		this.norm = norm;
	}

	public int getPvgl() {
		return this.pvgl;
	}

	public void setPvgl(int pvgl) {
		this.pvgl = pvgl;
	}

	public String getSortiment_Diaetetika() {
		return this.sortiment_Diaetetika;
	}

	public void setSortiment_Diaetetika(String sortiment_Diaetetika) {
		this.sortiment_Diaetetika = sortiment_Diaetetika;
	}

	public String getSortiment_Diagnostika() {
		return this.sortiment_Diagnostika;
	}

	public void setSortiment_Diagnostika(String sortiment_Diagnostika) {
		this.sortiment_Diagnostika = sortiment_Diagnostika;
	}

	public String getSortiment_Enterale_Ernaehrung() {
		return this.sortiment_Enterale_Ernaehrung;
	}

	public void setSortiment_Enterale_Ernaehrung(String sortiment_Enterale_Ernaehrung) {
		this.sortiment_Enterale_Ernaehrung = sortiment_Enterale_Ernaehrung;
	}

	public String getSortiment_Hilfsmittel() {
		return this.sortiment_Hilfsmittel;
	}

	public void setSortiment_Hilfsmittel(String sortiment_Hilfsmittel) {
		this.sortiment_Hilfsmittel = sortiment_Hilfsmittel;
	}

	public String getSortiment_Homoeopathika() {
		return this.sortiment_Homoeopathika;
	}

	public void setSortiment_Homoeopathika(String sortiment_Homoeopathika) {
		this.sortiment_Homoeopathika = sortiment_Homoeopathika;
	}

	public String getSortiment_IFAP() {
		return this.sortiment_IFAP;
	}

	public void setSortiment_IFAP(String sortiment_IFAP) {
		this.sortiment_IFAP = sortiment_IFAP;
	}

	public String getSortiment_KlinikArznei() {
		return this.sortiment_KlinikArznei;
	}

	public void setSortiment_KlinikArznei(String sortiment_KlinikArznei) {
		this.sortiment_KlinikArznei = sortiment_KlinikArznei;
	}

	public String getSortiment_Schwangerschaftstest() {
		return this.sortiment_Schwangerschaftstest;
	}

	public void setSortiment_Schwangerschaftstest(String sortiment_Schwangerschaftstest) {
		this.sortiment_Schwangerschaftstest = sortiment_Schwangerschaftstest;
	}

	public String getSortiment_Teststreifen() {
		return this.sortiment_Teststreifen;
	}

	public void setSortiment_Teststreifen(String sortiment_Teststreifen) {
		this.sortiment_Teststreifen = sortiment_Teststreifen;
	}

	public int getSortiment_Tierarzneimittel() {
		return this.sortiment_Tierarzneimittel;
	}

	public void setSortiment_Tierarzneimittel(int sortiment_Tierarzneimittel) {
		this.sortiment_Tierarzneimittel = sortiment_Tierarzneimittel;
	}

	public String getSortiment_Verbandmittel() {
		return this.sortiment_Verbandmittel;
	}

	public void setSortiment_Verbandmittel(String sortiment_Verbandmittel) {
		this.sortiment_Verbandmittel = sortiment_Verbandmittel;
	}

	public String getTeilbarkeit() {
		return this.teilbarkeit;
	}

	public void setTeilbarkeit(String teilbarkeit) {
		this.teilbarkeit = teilbarkeit;
	}

	public BigDecimal getZuzahlung() {
		return this.zuzahlung;
	}

	public void setZuzahlung(BigDecimal zuzahlung) {
		this.zuzahlung = zuzahlung;
	}

	public Produkt getProdukt() {
		return this.produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

}