package isi.ztm.ztmcontrat.daointerface;

import java.util.List;

import isi.ztm.ztmcontrat.entite.Cocontractant;



public interface ICocontractantDao {
	public void ajouterCocontractant(Cocontractant c);
	public void modifierCocontractant(Cocontractant c);
    public List<Cocontractant> listAllCocontractant();
	public Cocontractant rechercherCocontractantById(int id);
    public Cocontractant rechercherCocontractant(String nom);
    public void supprimerCocontractant(Cocontractant c);
    public Cocontractant findCoByNomAndAdresse(String nom, String adresse);
    public List<Object[]> getNbContratParCo();
	public List<Object[]> getNbContratPreavisParCo();
}
