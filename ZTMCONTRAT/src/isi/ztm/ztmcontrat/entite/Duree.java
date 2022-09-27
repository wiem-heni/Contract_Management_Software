package isi.ztm.ztmcontrat.entite;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Duree
 *
 */
@Entity

public class Duree implements Serializable {

	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Id
	private int id;
	private int nb;
	private String unite;
	private static final long serialVersionUID = 1L;

	public Duree() {
		super();
	}    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getUnite() {
		return this.unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}
	public int getNb() {
		return nb;
	}
	public void setNb(int nb) {
		this.nb = nb;
	}
   
}
