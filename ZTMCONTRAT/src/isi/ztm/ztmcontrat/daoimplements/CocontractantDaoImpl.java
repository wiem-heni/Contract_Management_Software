package isi.ztm.ztmcontrat.daoimplements;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import isi.ztm.ztmcontrat.daointerface.ICocontractantDao;
import isi.ztm.ztmcontrat.entite.Cocontractant;
import isi.ztm.ztmcontrat.entite.User;
@Repository
public class CocontractantDaoImpl implements ICocontractantDao {
	@PersistenceContext
	EntityManager em;

	public CocontractantDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public void ajouterCocontractant(Cocontractant c) {
		// TODO Auto-generated method stub
		em.persist(c);
	}

	
	public void modifierCocontractant(Cocontractant c) {
		// TODO Auto-generated method stub
		em.merge(c);
		
	}

	
	public List<Cocontractant> listAllCocontractant() {
		// TODO Auto-generated method stub
		List<Cocontractant> list = null;
		Query q = em.createQuery("select c from Cocontractant c");

		try {

			list = q.getResultList();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return list;
	}

	
	public Cocontractant rechercherCocontractant(String nom) {
		// TODO Auto-generated method stub
			Cocontractant found = null;

		Query q = em.createQuery("select u from Cocontractant u where u.nom =:n");

		q.setParameter("n", nom);
		

		try {
			
			found = (Cocontractant) q.getSingleResult();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return found;
	}

	
	public Cocontractant rechercherCocontractantById(int id) {
		 return em.find(Cocontractant.class, id);
	}


	public void supprimerCocontractant(Cocontractant c) {
		em.remove(em.merge(c));
	}


	
	public Cocontractant findCoByNomAndAdresse(String nom, String adresse) {
		// TODO Auto-generated method stub
		Cocontractant found = null;

		Query q = em.createQuery("select u from Cocontractant u where u.nom =:n and u.adresse =:x");

		q.setParameter("n", nom);
		q.setParameter("x", adresse);

		try {
			
			found = (Cocontractant) q.getSingleResult();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return found;
	}


	
	public List<Object[]> getNbContratParCo() {
		List<Object[]>	list = null;	
		Query q = em.createQuery("SELECT co.nom, count(c.idContrat) as nb FROM Contrat as c join c.cocontractant as co group by co.id");

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


	
	public List<Object[]> getNbContratPreavisParCo() {
		List<Object[]>	list = null;	
		Query q = em.createQuery("SELECT co.nom, count(c.idContrat) as nb FROM Contrat as c join c.cocontractant as co where c.etatContrat=:e group by co.id");
		q.setParameter("e", "atteint préavis");
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

}
