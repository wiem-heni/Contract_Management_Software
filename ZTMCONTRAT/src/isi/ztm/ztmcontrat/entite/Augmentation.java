package isi.ztm.ztmcontrat.entite;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Augmentation
 *
 */
@Entity

public class Augmentation implements Serializable {

	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Id
	private int id;
	private String taux;
	private Date date;
	private static final long serialVersionUID = 1L;

	public Augmentation() {
		super();
	}   
	   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getTaux() {
		return this.taux;
	}

	public void setTaux(String taux) {
		this.taux = taux;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
   
}
