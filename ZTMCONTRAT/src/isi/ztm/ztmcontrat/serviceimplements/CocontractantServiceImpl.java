package isi.ztm.ztmcontrat.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.ztm.ztmcontrat.daointerface.ICocontractantDao;
import isi.ztm.ztmcontrat.entite.Cocontractant;
import isi.ztm.ztmcontrat.serviceinterface.ICocontractantService;
@Transactional
@Service

public class CocontractantServiceImpl implements ICocontractantService {
	@Autowired
	private ICocontractantDao CocontractantDao;
	public CocontractantServiceImpl() {
		}

	public void ajouterCocontractant(Cocontractant c) {
		CocontractantDao.ajouterCocontractant(c);		
	}


	public void modifierCocontractant(Cocontractant c) {
		CocontractantDao.modifierCocontractant(c);
	}

	
	public List<Cocontractant> listAllCocontractant() {
		// TODO Auto-generated method stub
		return 	CocontractantDao.listAllCocontractant();
	}

	
	public Cocontractant rechercherCocontractant(String nom) {
		// TODO Auto-generated method stub
		return 	CocontractantDao.rechercherCocontractant(nom);
	}


	public Cocontractant rechercherCocontractantById(int id) {
		// TODO Auto-generated method stub
		return CocontractantDao.rechercherCocontractantById(id);
	}

	
	public void supprimerCocontractant(Cocontractant c) {
		// TODO Auto-generated method stub
		CocontractantDao.supprimerCocontractant(c);
	}

	
	public Cocontractant findCoByNomAndAdresse(String nom, String adresse) {
		// TODO Auto-generated method stub
		return CocontractantDao.findCoByNomAndAdresse(nom, adresse);
	}

	
	public List<Object[]> getNbContratParCo() {
		// TODO Auto-generated method stub
		return CocontractantDao.getNbContratParCo();
	}

	
	public List<Object[]> getNbContratPreavisParCo() {
		// TODO Auto-generated method stub
		return CocontractantDao.getNbContratPreavisParCo();
	}

}
