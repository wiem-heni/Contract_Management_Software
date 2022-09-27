package isi.ztm.ztmcontrat.entite;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: File
 *
 */
@Entity

public class File implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	@ManyToOne
	@JoinColumn(name="contrat_id")
	private Contrat contrat;
	private static final long serialVersionUID = 1L;

	public File() {
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
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
   
}
