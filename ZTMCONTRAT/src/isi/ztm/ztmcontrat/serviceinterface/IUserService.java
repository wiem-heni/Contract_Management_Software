package isi.ztm.ztmcontrat.serviceinterface;

import java.util.List;

import isi.ztm.ztmcontrat.entite.User;

public interface IUserService {
	public void ajouterUser(User c);
	public void modifierUser(User c);
	public List<User> listAllUsers();
	public User rechercherUserByLoginAndPassword(String l, String p);
	public boolean authentificationUser(String login,String password);
	public void SupprimerUser(User c);
	public User findUserByEmail(String email);
	public User findUserByCin(String c);
	public User findUserByLogin(String log);


}
