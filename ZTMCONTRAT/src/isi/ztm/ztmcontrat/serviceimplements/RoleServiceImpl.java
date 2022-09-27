package isi.ztm.ztmcontrat.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.ztm.ztmcontrat.daointerface.IRoleDao;
import isi.ztm.ztmcontrat.entite.Role;
import isi.ztm.ztmcontrat.serviceinterface.IRoleService;
@Transactional
@Service
public class RoleServiceImpl implements IRoleService{
	@Autowired
	private IRoleDao roleDao;
	public RoleServiceImpl() {

}

	
	public void ajouterRole(Role r) {
		// TODO Auto-generated method stub
		roleDao.ajouterRole(r);
	}

	
	public void modifierRole(Role r) {
		// TODO Auto-generated method stub
		roleDao.modifierRole(r);
	}

	
	public List<Role> listAllRole() {
		// TODO Auto-generated method stub
		return roleDao.listAllRole();
	}

}
