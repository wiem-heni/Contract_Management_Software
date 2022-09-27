package isi.ztm.ztmcontrat.entite;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Entity implementation class for Entity: Contrat
 *
 */
@Entity

public class Contrat implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContrat;
	private String etatContrat;
	private String codeContrat;
	private int nombre;
	private String periode;
	@ManyToOne
	@JoinColumn(name="co_id")
	private Cocontractant cocontractant;
	private String objetContrat;
	private String periodeContrat;
	private String delaiPreavis;
	private String typeContrat;
	private int anneeSignature;
	private String unite;
	private int nb;
	private float cout;
	private String observation;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	@Temporal(TemporalType.DATE)
	private Date dateRenouvellement;
	private Date dateAugmentation;
	@OneToMany(mappedBy="contrat",cascade= CascadeType.ALL,fetch= FetchType.EAGER)
	private List<Historique> listHistorique;
	private float taux;
@ManyToOne
@JoinColumn(name="categorie_id")
	private Categorie categorie;
@OneToMany(mappedBy="contrat",cascade= CascadeType.ALL,fetch= FetchType.EAGER)
@Fetch(value = FetchMode.SUBSELECT)
 private List<File> listFiles;
	
	private static final long serialVersionUID = 1L;

	public Contrat() {
		super();
	}

	
	public int getIdContrat() {
		return this.idContrat;
	}

	public void setIdContrat(int idContrat) {
		this.idContrat = idContrat;
	}

	public String getCodeContrat() {
		return this.codeContrat;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public Date getDateAugmentation() {
		return dateAugmentation;
	}

	public void setDateAugmentation(Date dateAugmentation) {
		this.dateAugmentation = dateAugmentation;
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	public void setCodeContrat(String codeContrat) {
		this.codeContrat = codeContrat;
	}

	public String getObjetContrat() {
		return this.objetContrat;
	}

	public void setObjetContrat(String objetContrat) {
		this.objetContrat = objetContrat;
	}

	public String getPeriodeContrat() {
		return this.periodeContrat;
	}

	public void setPeriodeContrat(String periodeContrat) {
		this.periodeContrat = periodeContrat;
	}

	public int getAnneeSignature() {
		return this.anneeSignature;
	}

	public void setAnneeSignature(int anneeSignature) {
		this.anneeSignature = anneeSignature;
	}

	public float getCout() {
		return this.cout;
	}

	public void setCout(float cout) {
		this.cout = cout;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}


	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDelaiPreavis() {
		return delaiPreavis;
	}

	public void setDelaiPreavis(String delaiPreavis) {
		this.delaiPreavis = delaiPreavis;
	}


	public String getEtatContrat() {
		return etatContrat;
	}

	public void setEtatContrat(String etatContrat) {
		this.etatContrat = etatContrat;
	}

	public String getUnite() {
		return unite;
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

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public Date getDateRenouvellement() {
		return dateRenouvellement;
	}

	public void setDateRenouvellement(Date dateRenouvellement) {
		this.dateRenouvellement = dateRenouvellement;
	}



	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public List<Historique> getListHistorique() {
		return listHistorique;
	}


	public void setListHistorique(List<Historique> listHistorique) {
		this.listHistorique = listHistorique;
	}


	public Cocontractant getCocontractant() {
		return cocontractant;
	}


	public void setCocontractant(Cocontractant cocontractant) {
		this.cocontractant = cocontractant;
	}


	public List<File> getListFiles() {
		return listFiles;
	}


	public void setListFiles(List<File> listFiles) {
		this.listFiles = listFiles;
	}



	


}
