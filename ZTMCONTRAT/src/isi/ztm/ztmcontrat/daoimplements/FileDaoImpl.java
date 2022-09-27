package isi.ztm.ztmcontrat.daoimplements;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import isi.ztm.ztmcontrat.daointerface.IFileDao;
import isi.ztm.ztmcontrat.entite.File;
@Repository
public class FileDaoImpl implements IFileDao
{
	@PersistenceContext
	EntityManager em;
	
	public FileDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public void ajouterFichier(File c) {
		// TODO Auto-generated method stub
		em.persist(c);
		}

	
	public void modifierFichier(File c) {
		// TODO Auto-generated method stub
		em.merge(c);
	}

	
	public File rechercherFichierById(int id) {
		 return em.find(File.class, id);
	}

	
	public void supprimerFichier(File c) {
		// TODO Auto-generated method stub
		em.remove(em.merge(c));
	}

	
	public List<File> listAllFichier() {
		List<File> list = null;
		Query q = em.createQuery("select r from File r");

		try {

			list = q.getResultList();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return list;
	}

}
