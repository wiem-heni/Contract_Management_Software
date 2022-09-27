package isi.ztm.ztmcontrat.daoimplements;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import isi.ztm.ztmcontrat.daointerface.IUserDao;
import isi.ztm.ztmcontrat.entite.User;

@Repository
public class UserDaoImpl implements IUserDao {
	
	@PersistenceContext
	EntityManager em;

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public void ajouterUser(User c) {
		em.persist(c);

	}

	public void modifierUser(User c) {
		em.merge(c);

	}

	public List<User> listAllUsers() {
		List<User> list = null;
		Query q = em.createQuery("select c from User c where c.login not like :x");
		q.setParameter("x","admin");

		try {

			list = q.getResultList();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return list;
	}

	public User rechercherUserByLoginAndPassword(String l, String p) {
		User found = null;

		Query q = em.createQuery("select u from User u where u.login =:log and u.password =:pass");

		q.setParameter("log", l);
		q.setParameter("pass", p);

		try {
			
			found = (User) q.getSingleResult();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return found;
	}

	
	public boolean authentificationUser(String login, String password) {
		boolean trouve = false;
		User u;
		u = rechercherUserByLoginAndPassword(login, password);

		if (u != null) {
			trouve = true;
		}

		return trouve;
	}

	
	public void SupprimerUser(User c) {
		em.remove(em.merge(c));		
	}

	
	public User findUserByEmail(String email) {
		User found = null;

		Query query = em.createQuery("select u from User u where u.emailUser =:e");
		query.setParameter("e", email);
		
		try {
			
			found = (User) query.getSingleResult();
			
		} catch (NoResultException e) {
			e.getMessage();
		}

		return found;
	}

	
	public User findUserByCin(String c) {
		User found = null;

		Query query = em.createQuery("select u from User u where u.cin =:e");
		query.setParameter("e", c);
		
		try {
			
			found = (User) query.getSingleResult();
			
		} catch (NoResultException e) {
			e.getMessage();
		}

		return found;
	}

	
	public User findUserByLogin(String log) {
		User found = null;

		Query query = em.createQuery("select u from User u where u.login =:l");
		query.setParameter("l", log);
		
		try {
			
			found = (User) query.getSingleResult();
			
		} catch (NoResultException e) {
			e.getMessage();
		}

		return found;
	}

	
	

}
