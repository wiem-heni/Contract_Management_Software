package isi.ztm.ztmcontrat.entite;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: sociétéSource
 *
 */
@Entity(name="sociétéSource")

public class SocieteSource implements Serializable {

	
	private int idSociété;
	private String nom;
	private String adresse;
	private int telephone;
	private String email;
	private static final long serialVersionUID = 1L;

	public SocieteSource() {
		super();
	}   
	@Id    
	public int getIdSociété() {
		return this.idSociété;
	}

	public void setIdSociété(int idSociété) {
		this.idSociété = idSociété;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}   
	public int getTelephone() {
		return this.telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
   
}
