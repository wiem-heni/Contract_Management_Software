package isi.ztm.ztmcontrat.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.ztm.ztmcontrat.daointerface.ISourceDao;
import isi.ztm.ztmcontrat.entite.SocieteSource;
import isi.ztm.ztmcontrat.serviceinterface.ISourceService;
@Transactional
@Service
public class SourceServiceImpl implements ISourceService{
	@Autowired
	private ISourceDao sourceDao;

	public SourceServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public void ajouterSource(SocieteSource c) {
		sourceDao.ajouterSource(c);		
	}

	
	public void modifierSource(SocieteSource c) {
		sourceDao.modifierSource(c);		
	}

	
	public List<SocieteSource> listAllSource() {
		// TODO Auto-generated method stub
		
		return sourceDao.listAllSource();
	}

	
	public SocieteSource rechercherSource(String nom) {
			
		return sourceDao.rechercherSource(nom);
	}

}
