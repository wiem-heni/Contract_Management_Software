package isi.ztm.ztmcontrat.serviceinterface;

import java.util.List;

import isi.ztm.ztmcontrat.entite.File;

public interface IFileService {
	public void ajouterFichier(File c);
	public void modifierFichier(File c);
	public File rechercherFichierById(int id);
	public void supprimerFichier(File c);
    public List<File> listAllFichier();
}
