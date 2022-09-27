package isi.ztm.ztmcontrat.entite;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: historique
 *
 */
@Entity

public class Historique implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private int id;
	private String etatContrat;
	private String codeContrat;
	private String cocontractant;
	private String objetContrat;
	private String periodeContrat;
	private String delaiPreavis;
	private String typeContrat;
	private int anneeSignature;
	private float cout;
	private String observation;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	@Temporal(TemporalType.DATE)
	private Date dateRenouvellement;
	@Temporal(TemporalType.DATE)
	private Date dateAugmentation;
	private float taux;
	private Date dateModif;
	private String utilisateur;
	private String typeTransaction;
	private String cat;
	@ManyToOne
	@JoinColumn(name="contrat_id",insertable=true,updatable=true)
	private Contrat contrat;
	

	private static final long serialVersionUID = 1L;

	public Historique() {
		super();
	}   
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateModif() {
		return dateModif;
	}
	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}
	public String getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}
	public String getTypeTransaction() {
		return typeTransaction;
	}
	public void setTypeTransaction(String typeTransaction) {
		this.typeTransaction = typeTransaction;
	}
	public String getEtatContrat() {
		return etatContrat;
	}
	public void setEtatContrat(String etatContrat) {
		this.etatContrat = etatContrat;
	}
	public String getCodeContrat() {
		return codeContrat;
	}
	public void setCodeContrat(String codeContrat) {
		this.codeContrat = codeContrat;
	}
	public String getCocontractant() {
		return cocontractant;
	}
	public void setCocontractant(String cocontractant) {
		this.cocontractant = cocontractant;
	}
	public String getObjetContrat() {
		return objetContrat;
	}
	public void setObjetContrat(String objetContrat) {
		this.objetContrat = objetContrat;
	}
	public String getPeriodeContrat() {
		return periodeContrat;
	}
	public void setPeriodeContrat(String periodeContrat) {
		this.periodeContrat = periodeContrat;
	}
	public String getDelaiPreavis() {
		return delaiPreavis;
	}
	public void setDelaiPreavis(String delaiPreavis) {
		this.delaiPreavis = delaiPreavis;
	}
	public String getTypeContrat() {
		return typeContrat;
	}
	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}
	public int getAnneeSignature() {
		return anneeSignature;
	}
	public void setAnneeSignature(int anneeSignature) {
		this.anneeSignature = anneeSignature;
	}
	public float getCout() {
		return cout;
	}
	public void setCout(float cout) {
		this.cout = cout;
	}
	public String getObservation() {
		return observation;
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
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Date getDateRenouvellement() {
		return dateRenouvellement;
	}
	public void setDateRenouvellement(Date dateRenouvellement) {
		this.dateRenouvellement = dateRenouvellement;
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

	
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}




	
   
}
