package isi.ztm.ztmcontrat.entite;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cocontractant
 *
 */
@Entity

public class Cocontractant implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	private String nom;
	private String adresse;
	private Date dateCreation;
	private String email;
	private int telephone;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="cocontractant")
    private List<Contrat> listContratCo;
	public Cocontractant() {
		super();
	}  
	
	 
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public int getTelephone() {
		return this.telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public List<Contrat> getListContratCo() {
		
		return listContratCo;
	}


	public void setListContratCo(List<Contrat> listContratCo) {
		this.listContratCo = listContratCo;
	}
   
}
