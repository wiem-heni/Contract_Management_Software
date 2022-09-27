package isi.ztm.ztmcontrat.daoimplements;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import isi.ztm.ztmcontrat.daointerface.IDureeDao;
import isi.ztm.ztmcontrat.entite.Duree;
@Repository
public class DureeDaoImpl implements IDureeDao{

	@PersistenceContext
	EntityManager em;
	
	public DureeDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public void ajouterDuree(Duree c) {
		// TODO Auto-generated method stub
		em.persist(c);

	}

	
	public void modifierDuree(Duree c) {
		// TODO Auto-generated method stub
		em.merge(c);

	}

}
