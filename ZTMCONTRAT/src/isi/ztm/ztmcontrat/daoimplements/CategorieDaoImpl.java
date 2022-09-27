package isi.ztm.ztmcontrat.daoimplements;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import isi.ztm.ztmcontrat.daointerface.ICategorieDao;
import isi.ztm.ztmcontrat.entite.Categorie;
import isi.ztm.ztmcontrat.entite.Cocontractant;
import isi.ztm.ztmcontrat.entite.Contrat;
@Repository
public class CategorieDaoImpl implements ICategorieDao{
	@PersistenceContext
	EntityManager em;
	public CategorieDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public void ajouterCategorie(Categorie c) {
		em.persist(c);		
	}

	
	public void modifierCategorie(Categorie c) {
       em.merge(c);
	}

	
	public List<Categorie> listAllCategorie() {
		List<Categorie> list = null;
		Query q = em.createQuery("select c from Categorie c");

		try {

			list = q.getResultList();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return list;
		}

	
	public Categorie rechercherCategorieById(int id) {
		return em.find(Categorie.class, id);
	}

	
	public Categorie rechercherCategorieByNom(String nom) {
Categorie found = null;
		
		Query q =em.createQuery("select c from Categorie c where c.nom =:n");
		
		q.setParameter("n", nom);
		
		try {
			found = (Categorie) q.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		
		

		return found;
	}


	
	public void supprimerCategorie(Categorie c) {
		em.remove(em.merge(c));
	
	}


	
	public List<Object[]> getNbContratParCategorie() {
		List<Object[]>	list = null;	
		Query q = em.createQuery("SELECT cat.nom, count(c.idContrat) as nb FROM Contrat as c join c.categorie as cat group by cat.id");

		try { 

			list = q.getResultList();

	        for (Object[] obj : list) {
	        	System.out.println(obj[0]);
	        	System.out.println(obj[1]);
	        }
			
		} catch (NoResultException e) {
			// TODO: handle exception
		}

     
		return list;
	}


	
	public List<Object[]> getNbContratPreavisParCategorie() {
		List<Object[]>	list = null;	
		Query q = em.createQuery("SELECT cat.nom, count(c.idContrat) as nb FROM Contrat as c join c.categorie as cat where c.etatContrat=:n group by cat.id");
		q.setParameter("n", "atteint préavis");

		try { 

			list = q.getResultList();

	       
			
		} catch (NoResultException e) {
			// TODO: handle exception
		}

     
		return list;
	}


}
