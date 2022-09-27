package isi.ztm.ztmcontrat.daoimplements;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import isi.ztm.ztmcontrat.daointerface.IRoleDao;
import isi.ztm.ztmcontrat.entite.Role;
@Repository
public class RoleDaoImpl implements IRoleDao{
	@PersistenceContext
	EntityManager em;
	public RoleDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public void ajouterRole(Role r) {
em.persist(r);		
	}

	
	public void modifierRole(Role r) {
		// TODO Auto-generated method stub
		em.merge(r);
	}

	
	public List<Role> listAllRole() {
		List<Role> list = null;
		Query q = em.createQuery("select r from Role r");

		try {

			list = q.getResultList();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return list;
	}

}
