package isi.ztm.ztmcontrat.serviceimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.ztm.ztmcontrat.daointerface.IDureeDao;
import isi.ztm.ztmcontrat.entite.Duree;
import isi.ztm.ztmcontrat.serviceinterface.IDureeService;
@Transactional
@Service
public class DureeServiceImpl implements IDureeService{
	@Autowired
	private IDureeDao dureeDao;

	public DureeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public void ajouterDuree(Duree c) {
		// TODO Auto-generated method stub
		dureeDao.ajouterDuree(c);
	}

	
	public void modifierDuree(Duree c) {
		// TODO Auto-generated method stub
		dureeDao.modifierDuree(c);
	}

}
