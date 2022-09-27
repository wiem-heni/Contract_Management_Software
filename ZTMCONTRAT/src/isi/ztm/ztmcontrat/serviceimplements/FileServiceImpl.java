package isi.ztm.ztmcontrat.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.ztm.ztmcontrat.daointerface.IFileDao;
import isi.ztm.ztmcontrat.entite.File;
import isi.ztm.ztmcontrat.serviceinterface.IFileService;
@Transactional
@Service
public class FileServiceImpl implements IFileService{
	@Autowired
	private IFileDao FileDao;
	public FileServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public void ajouterFichier(File c) {
		// TODO Auto-generated method stub
		FileDao.ajouterFichier(c);
	}

	
	public void modifierFichier(File c) {
		// TODO Auto-generated method stub
		FileDao.modifierFichier(c);
	}

	
	public File rechercherFichierById(int id) {
		// TODO Auto-generated method stub
		return FileDao.rechercherFichierById(id);
	}

	
	public void supprimerFichier(File c) {
		// TODO Auto-generated method stub
		FileDao.supprimerFichier(c);
	}

	
	public List<File> listAllFichier() {
		// TODO Auto-generated method stub
		return FileDao.listAllFichier();
	}

}
