package isi.ztm.ztmcontrat.serviceinterface;

import java.util.List;

import isi.ztm.ztmcontrat.entite.Categorie;


public interface ICategorieService {
	public void ajouterCategorie(Categorie c);
	public void modifierCategorie(Categorie c);
	public List<Categorie> listAllCategorie();
	public Categorie rechercherCategorieById(int id);
	public Categorie rechercherCategorieByNom(String nom);
	public void supprimerCategorie(Categorie c);
	public List<Object[]> getNbContratParCategorie();
	public List<Object[]> getNbContratPreavisParCategorie();


}