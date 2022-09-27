package isi.ztm.ztmcontrat.daointerface;

import java.util.List;
import isi.ztm.ztmcontrat.entite.Contrat;
import isi.ztm.ztmcontrat.entite.SocieteSource;

public interface ISourceDao {
	public void ajouterSource(SocieteSource c);

	void modifierSource(SocieteSource c);

	public List<SocieteSource> listAllSource();

	public SocieteSource rechercherSource(String nom);
}
