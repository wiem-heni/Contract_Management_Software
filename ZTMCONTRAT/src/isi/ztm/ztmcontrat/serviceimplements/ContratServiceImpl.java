package isi.ztm.ztmcontrat.serviceimplements;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.ztm.ztmcontrat.daointerface.IContratDao;
import isi.ztm.ztmcontrat.entite.Categorie;
import isi.ztm.ztmcontrat.entite.Cocontractant;
import isi.ztm.ztmcontrat.entite.Contrat;
import isi.ztm.ztmcontrat.serviceinterface.IContratService;


@Transactional
@Service
public  class ContratServiceImpl implements IContratService{
	
	@Autowired
	private IContratDao contratDao;

	public ContratServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public void ajouterContrat(Contrat c) {

		contratDao.ajouterContrat(c);
	}

	
	public void modifierContrat(Contrat c) {
	
		contratDao.modifierContrat(c);
		
		
	}

	
	public List<Contrat> listAllContrats() {
		
		return contratDao.listAllContrats();
	}

	
	public Contrat rechercherContratById(int id) {
		
		return contratDao.rechercherContratById(id);
	}

	
	public Contrat rechercherContratByCode(String code) {
		
		return contratDao.rechercherContratByCode(code);
	}


	
	public List<Contrat> listContratFerme() {
		// TODO Auto-generated method stub
		return contratDao.listContratFerme();
	}


	
	public List<Contrat> listContratFermeEnCours() {
		// TODO Auto-generated method stub
		return contratDao.listContratFermeEnCours();
	}


	
	public List<Contrat> listContratFermeExpirer() {
		// TODO Auto-generated method stub
		return contratDao.listContratFermeExpirer();
	}


	
	public List<Contrat> listContratFermeAvantExpiration() {
		// TODO Auto-generated method stub
		return contratDao.listContratFermeAvantExpiration();
	}


	
	public List<Contrat> listContratRenouvelable() {
		// TODO Auto-generated method stub
		return contratDao.listContratRenouvelable();
	}


	
	public List<Contrat> listContratRenouvelableEnCours() {
		// TODO Auto-generated method stub
		return contratDao.listContratRenouvelableEnCours();
	}


	
	public List<Contrat> listContratRenouvelableAvantExpiration() {
		// TODO Auto-generated method stub
		return contratDao.listContratRenouvelableAvantExpiration();
	}


	
	public List<Contrat> listContratRenouvelableExpirer() {
		// TODO Auto-generated method stub
		return contratDao.listContratRenouvelableExpirer();
	}


	
	public int nbContratEnCours() {
		// TODO Auto-generated method stub
		return contratDao.nbContratEnCours();
	}


	
	public int nbContratFermeEnCours() {
		// TODO Auto-generated method stub
		return contratDao.nbContratFermeEnCours();
	}


	
	public int nbContratRenouvelableEnCours() {
		// TODO Auto-generated method stub
		return contratDao.nbContratRenouvelableEnCours();
	}


	
	public int nbContratRenouvelableAvantExpiration() {
		// TODO Auto-generated method stub
		return contratDao.nbContratRenouvelableAvantExpiration();
	}


	
	public int nbContratRenouvelableExpirer() {
		// TODO Auto-generated method stub
		return contratDao.nbContratRenouvelableExpirer();
	}


	
	public int nbContratFermeExpirer() {
		// TODO Auto-generated method stub
		return contratDao.nbContratFermeExpirer();
	}


	
	public int nbContratFermeAvantExpiration() {
		// TODO Auto-generated method stub
		return contratDao.nbContratFermeAvantExpiration();
	}


	
	public int nbContratExpirer() {
		// TODO Auto-generated method stub
		return contratDao.nbContratExpirer();
	}


	
	

	
	public String testEtatFerme(Contrat c) {
		// TODO Auto-generated method stub
		return contratDao.testEtatFerme(c);
	}


	
	public String testEtatRenouvelable(Contrat c) {
		// TODO Auto-generated method stub
		return contratDao.testEtatRenouvelable(c);
	}


	
	public void renouveler(Contrat c) {
		// TODO Auto-generated method stub
		contratDao.renouveler(c);
	}


	
	public Date DateRenouveler(Contrat c) {
		// TODO Auto-generated method stub
		return contratDao.DateRenouveler(c);
	}


	
	public List<Contrat> listContratRenouvelableAtteintPreavis() {
		// TODO Auto-generated method stub
		return contratDao.listContratRenouvelableAtteintPreavis();
	}


	
	public List<Contrat> listContratRenouvelableAvantPreavis() {
		// TODO Auto-generated method stub
		return contratDao.listContratRenouvelableAvantPreavis();
	}


	
	public int nbContratRenouvelableAvantPreavis() {
		// TODO Auto-generated method stub
		return contratDao.nbContratRenouvelableAvantPreavis();
	}


	
	public int nbContratRenouvelableAtteintPreavis() {
		// TODO Auto-generated method stub
		return contratDao.nbContratRenouvelableAtteintPreavis();
	}


	
	public void fermer(Contrat c) {
		// TODO Auto-generated method stub
		contratDao.fermer(c);
	}


	
	public List<Contrat> listContratAnnuler() {
		// TODO Auto-generated method stub
		return contratDao.listContratAnnuler();
	}


	
	public int nbContratAnnuler() {
		// TODO Auto-generated method stub
		return contratDao.nbContratAnnuler();
	}


	
	public List<Contrat> rechercheParCritere(Cocontractant co, String obj, String type, Categorie cat, String an, String prix, Date d,
			Date f) {
		// TODO Auto-generated method stub
		return contratDao.rechercheParCritere(co, obj, type, cat, an, prix, d, f);
	}


	
	public List<String> listNotif() {
		// TODO Auto-generated method stub
		return contratDao.listNotif();
	}


	
	public List<Contrat> listPourNotif() {
		// TODO Auto-generated method stub
		return contratDao.listPourNotif();
	}


	
	public int nbNotif() {
		// TODO Auto-generated method stub
		return contratDao.nbNotif();
	}

}
