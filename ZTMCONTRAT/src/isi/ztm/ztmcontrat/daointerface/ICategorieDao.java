package isi.ztm.ztmcontrat.daointerface;

import java.util.List;

import isi.ztm.ztmcontrat.entite.Categorie;

public interface ICategorieDao {
	public void ajouterCategorie(Categorie c);
	public void modifierCategorie(Categorie c);
	public Categorie rechercherCategorieById(int id);
	public Categorie rechercherCategorieByNom(String nom);
	public void supprimerCategorie(Categorie c);
    public List<Categorie> listAllCategorie();
	public List<Object[]> getNbContratParCategorie();
	public List<Object[]> getNbContratPreavisParCategorie();

}
