package isi.ztm.ztmcontrat.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.ztm.ztmcontrat.daointerface.ICategorieDao;
import isi.ztm.ztmcontrat.daointerface.IContratDao;
import isi.ztm.ztmcontrat.entite.Categorie;
import isi.ztm.ztmcontrat.serviceinterface.ICategorieService;
@Transactional
@Service
public class CategorieServiceImpl implements ICategorieService{
	@Autowired
	private ICategorieDao CategorieDao;
	public CategorieServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public void ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		CategorieDao.ajouterCategorie(c);
	}

	
	public void modifierCategorie(Categorie c) {
		// TODO Auto-generated method stub
		CategorieDao.modifierCategorie(c);
	}

	
	public List<Categorie> listAllCategorie() {
		// TODO Auto-generated method stub
		return CategorieDao.listAllCategorie();
	}

	
	public Categorie rechercherCategorieById(int id) {
		// TODO Auto-generated method stub
		return CategorieDao.rechercherCategorieById(id);
	}

	
	public Categorie rechercherCategorieByNom(String nom) {
		// TODO Auto-generated method stub
		return CategorieDao.rechercherCategorieByNom(nom);
	}


	
	public void supprimerCategorie(Categorie c) {
		CategorieDao.supprimerCategorie(c);
	}


	
	public List<Object[]> getNbContratParCategorie() {
		// TODO Auto-generated method stub
		return CategorieDao.getNbContratParCategorie();
	}


	
	public List<Object[]> getNbContratPreavisParCategorie() {
		// TODO Auto-generated method stub
		return CategorieDao.getNbContratPreavisParCategorie();
	}

}
