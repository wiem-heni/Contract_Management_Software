package isi.ztm.ztmcontrat.serviceinterface;

import java.util.Date;
import java.util.List;

import isi.ztm.ztmcontrat.entite.Categorie;
import isi.ztm.ztmcontrat.entite.Cocontractant;
import isi.ztm.ztmcontrat.entite.Contrat;

public interface IContratService {
	public void ajouterContrat(Contrat c);
	public void modifierContrat(Contrat c);
	public List<Contrat> listAllContrats();
	public List<Contrat> rechercheParCritere(Cocontractant co,String obj, String type, Categorie cat, String an, String prix, Date d, Date f);

	public Contrat rechercherContratById(int id);
	public Contrat rechercherContratByCode(String code);
	public List<Contrat> listContratFerme();//tous les contrats fermes
	public List<Contrat> listContratFermeEnCours();
	public List<Contrat> listContratFermeExpirer();
	public List<Contrat> listContratFermeAvantExpiration();//-31 jours avant leur expiration
	public List<Contrat> listContratRenouvelable();//tous les contrats renouvelables
	public List<Contrat> listContratRenouvelableEnCours();
	public List<Contrat> listContratRenouvelableAvantExpiration();//-31 jours avant leurs dates de fin(contrat renouvelable en attente)
	public List<Contrat> listContratRenouvelableExpirer();
	public List<Contrat> listContratRenouvelableAtteintPreavis();//les contrats qui ont atteint le delai de preavis
	public List<Contrat> listContratRenouvelableAvantPreavis();//-30 jours avant leurs delais de preavis(contrat renouvelable en attente)
	public void renouveler(Contrat c);
    public Date DateRenouveler(Contrat c);
	public String testEtatFerme(Contrat c);
	public String testEtatRenouvelable(Contrat c);
	public void fermer(Contrat c);
	public List<Contrat> listContratAnnuler();
	public int nbContratAnnuler();
	public List<String> listNotif();
	public List<Contrat> listPourNotif();
	public int nbNotif();

	
	public int nbContratRenouvelableAvantPreavis();
	public int nbContratRenouvelableAtteintPreavis();
	public int nbContratExpirer();
	public int nbContratEnCours();//fermes et renouvelables
	public int nbContratFermeEnCours();
	public int nbContratRenouvelableEnCours();
	public int nbContratRenouvelableAvantExpiration();//renouvelables en attente de decision
	public int nbContratRenouvelableExpirer();//contrats expirés(renouvelables )(delai preavis dépassé)
	public int nbContratFermeExpirer();//contrats expirés(fermes )
	public int nbContratFermeAvantExpiration();//30 jours avant leur fermeture(ne concerne que les contrats fermes)



}
