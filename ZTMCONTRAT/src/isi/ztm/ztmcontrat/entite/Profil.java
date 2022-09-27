package isi.ztm.ztmcontrat.entite;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Profil
 *
 */
@Entity

public class Profil implements Serializable {

	   
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Id
	private int id;
	private boolean responsableJuridique;
	private boolean collaborateur;
	private static final long serialVersionUID = 1L;

	public Profil() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public boolean getResponsableJuridique() {
		return this.responsableJuridique;
	}

	public void setResponsableJuridique(boolean responsableJuridique) {
		this.responsableJuridique = responsableJuridique;
	}   
	public boolean getCollaborateur() {
		return this.collaborateur;
	}

	public void setCollaborateur(boolean collaborateur) {
		this.collaborateur = collaborateur;
	}
   
}
