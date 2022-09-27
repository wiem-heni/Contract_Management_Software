package isi.ztm.ztmcontrat.entite;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: soci�t�Source
 *
 */
@Entity(name="soci�t�Source")

public class SocieteSource implements Serializable {

	
	private int idSoci�t�;
	private String nom;
	private String adresse;
	private int telephone;
	private String email;
	private static final long serialVersionUID = 1L;

	public SocieteSource() {
		super();
	}   
	@Id    
	public int getIdSoci�t�() {
		return this.idSoci�t�;
	}

	public void setIdSoci�t�(int idSoci�t�) {
		this.idSoci�t� = idSoci�t�;
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
