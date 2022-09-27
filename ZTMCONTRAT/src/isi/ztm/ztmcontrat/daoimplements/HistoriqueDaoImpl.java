package isi.ztm.ztmcontrat.daoimplements;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import isi.ztm.ztmcontrat.daointerface.IHistoriqueDao;
import isi.ztm.ztmcontrat.entite.Historique;
import isi.ztm.ztmcontrat.entite.User;
@Repository
public class HistoriqueDaoImpl implements IHistoriqueDao{
	@PersistenceContext
	EntityManager em;
	public HistoriqueDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public void ajouterHistorique(Historique h) {
em.persist(h);		
	}

	
	public void modifierHistorique(Historique h) {
em.merge(h);		
	}

	
	public List<Historique> listAllHistorique() {
		List<Historique> list = null;
		Query q = em.createQuery("select c from User c");

		try {

			list = q.getResultList();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return list;
	}

}
