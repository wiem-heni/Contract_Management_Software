package isi.ztm.ztmcontrat.daointerface;

import java.util.List;

import isi.ztm.ztmcontrat.entite.Role;


public interface IRoleDao {
	public void ajouterRole(Role r);
	public void modifierRole(Role r);
	public List<Role> listAllRole();
	
}
