package de.ifa.arznei.mobil.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Texte" database table.
 * 
 */
@Entity
@Table(name="Texte")
@NamedQuery(name="Texte.findAll", query="SELECT t FROM Texte t")
public class Texte implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private int id;

	/* The metadata constraints '[Nullable=true, MaxLength=255]' do not allow to format the value ... */
	@Column(name="Text_Data", length=65536)
	private String text_Data;

	public Texte() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText_Data() {
		return this.text_Data;
	}

	public void setText_Data(String text_Data) {
		this.text_Data = text_Data;
	}

}