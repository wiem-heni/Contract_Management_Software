package isi.ztm.ztmcontrat.serviceinterface;

import java.util.List;

import isi.ztm.ztmcontrat.entite.Role;

public interface IRoleService {
	public void ajouterRole(Role r);
	public void modifierRole(Role r);
	public List<Role> listAllRole();
}
