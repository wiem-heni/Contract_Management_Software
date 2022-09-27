package isi.ztm.ztmcontrat.serviceinterface;

import java.util.List;

import isi.ztm.ztmcontrat.entite.Historique;

public interface IHistoriqueService {
	public void ajouterHistorique(Historique h);
	public void modifierHistorique(Historique h);
	public List<Historique> listAllHistorique();
}
