package isi.ztm.ztmcontrat.daointerface;

import java.util.List;

import isi.ztm.ztmcontrat.entite.Historique;

public interface IHistoriqueDao {
	public void ajouterHistorique(Historique h);
	public void modifierHistorique(Historique h);
	public List<Historique> listAllHistorique();
}
