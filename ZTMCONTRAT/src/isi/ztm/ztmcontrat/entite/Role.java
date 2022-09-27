package isi.ztm.ztmcontrat.entite;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity

public class Role implements Serializable {

	   
	
	private int id;
	private boolean roleGestionContrat;
	private boolean roleGestionContractant;
	private boolean roleSuiviContrat;
	private boolean roleGestionUser;
	private boolean roleStatistique;
	private boolean roleRapport;
	private boolean roleGestionCategorie;
	private static final long serialVersionUID = 1L;

	public Role() {
		super();
	} 
	
	public Role(boolean roleGestionContrat, boolean roleGestionContractant, boolean roleSuiviContrat,
			boolean roleGestionUser, boolean roleStatistique, boolean roleRapport, boolean roleGestionCategorie) {
		super();
		this.roleGestionContrat = roleGestionContrat;
		this.roleGestionContractant = roleGestionContractant;
		this.roleSuiviContrat = roleSuiviContrat;
		this.roleGestionUser = roleGestionUser;
		this.roleStatistique = roleStatistique;
		this.roleRapport = roleRapport;
		this.roleGestionCategorie = roleGestionCategorie;
	}

	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public boolean getRoleGestionContrat() {
		return this.roleGestionContrat;
	}

	public void setRoleGestionContrat(boolean roleGestionContrat) {
		this.roleGestionContrat = roleGestionContrat;
	}   
	public boolean getRoleGestionContractant() {
		return this.roleGestionContractant;
	}

	public void setRoleGestionContractant(boolean roleGestionContractant) {
		this.roleGestionContractant = roleGestionContractant;
	}   
	public boolean getRoleSuiviContrat() {
		return this.roleSuiviContrat;
	}

	public void setRoleSuiviContrat(boolean roleSuiviContrat) {
		this.roleSuiviContrat = roleSuiviContrat;
	}   
	public boolean getRoleGestionUser() {
		return this.roleGestionUser;
	}

	public void setRoleGestionUser(boolean roleGestionUser) {
		this.roleGestionUser = roleGestionUser;
	}   
	public boolean getRoleStatistique() {
		return this.roleStatistique;
	}

	public void setRoleStatistique(boolean roleStatistique) {
		this.roleStatistique = roleStatistique;
	}   
	public boolean getRoleRapport() {
		return this.roleRapport;
	}

	public void setRoleRapport(boolean roleRapport) {
		this.roleRapport = roleRapport;
	}   
	public boolean getRoleGestionCategorie() {
		return this.roleGestionCategorie;
	}

	public void setRoleGestionCategorie(boolean roleGestionCategorie) {
		this.roleGestionCategorie = roleGestionCategorie;
	}
   
}
