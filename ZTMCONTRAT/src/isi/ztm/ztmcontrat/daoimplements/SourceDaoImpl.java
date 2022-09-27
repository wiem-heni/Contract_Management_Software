package isi.ztm.ztmcontrat.daoimplements;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import isi.ztm.ztmcontrat.daointerface.ISourceDao;
import isi.ztm.ztmcontrat.entite.SocieteSource;
@Repository
public class SourceDaoImpl implements ISourceDao{
	@PersistenceContext
	EntityManager em;

	public SourceDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterSource(SocieteSource c) {
		// TODO Auto-generated method stub
		em.persist(c);
		
	}

	@Override
	public void modifierSource(SocieteSource c) {
		// TODO Auto-generated method stub
		em.merge(c);
		
	}

	@Override
	public List<SocieteSource> listAllSource() {
		// TODO Auto-generated method stub
		List<SocieteSource> list = null;
		Query q = em.createQuery("select c from Source c");

		try {

			list = q.getResultList();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return list;
	}

	@Override
	public SocieteSource rechercherSource(String nom) {
		// TODO Auto-generated method stub
		SocieteSource found = null;
		
		Query q =em.createQuery("select c from Source c where c.nom =:n");
		
		q.setParameter("n", nom);
		
		try {
			
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		
		

		return found;
	}

}
