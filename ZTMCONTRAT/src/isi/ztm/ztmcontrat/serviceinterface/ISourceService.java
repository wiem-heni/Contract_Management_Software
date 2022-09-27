package isi.ztm.ztmcontrat.serviceinterface;

import java.util.List;

import isi.ztm.ztmcontrat.entite.SocieteSource;

public interface ISourceService {
	public void ajouterSource(SocieteSource c);

	void modifierSource(SocieteSource c);

	public List<SocieteSource> listAllSource();

	public SocieteSource rechercherSource(String nom);
}
