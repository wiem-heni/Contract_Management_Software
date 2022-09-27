package isi.ztm.ztmcontrat.entite;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Catégorie
 *
 */
@Entity
public class Categorie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private Date dateCreation;
	@OneToMany(mappedBy="categorie")
    private List<Contrat> listContrat;

	
	private static final long serialVersionUID = 1L;

	public Categorie() {
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

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Contrat> getListContrat() {
		return listContrat;
	}

	public void setListContrat(List<Contrat> listContrat) {
		this.listContrat = listContrat;
	}

	
}
