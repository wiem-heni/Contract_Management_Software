package isi.ztm.ztmcontrat.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.ztm.ztmcontrat.daointerface.IContratDao;
import isi.ztm.ztmcontrat.daointerface.IUserDao;
import isi.ztm.ztmcontrat.entite.User;
import isi.ztm.ztmcontrat.serviceinterface.IUserService;
@Transactional
@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao userDao;
	
	public UserServiceImpl() {
	}
	

	
	public void ajouterUser(User c) {
		userDao.ajouterUser(c);
		
	}

	
	public void modifierUser(User c) {
		userDao.modifierUser(c);
	}

	
	public List<User> listAllUsers() {
		
		return userDao.listAllUsers();
	}


	public User rechercherUserByLoginAndPassword(String l, String p) {
		return userDao.rechercherUserByLoginAndPassword(l, p);
	}



	
	public boolean authentificationUser(String login, String password) {
		
		return userDao.authentificationUser(login, password);
	}



	
	public void SupprimerUser(User c) {
    userDao.SupprimerUser(c);		
	}



	
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findUserByEmail(email);
	}




	public User findUserByCin(String c) {
		// TODO Auto-generated method stub
		return userDao.findUserByCin(c);
	}



	
	public User findUserByLogin(String log) {
		// TODO Auto-generated method stub
		return userDao.findUserByLogin(log);
	}

}
