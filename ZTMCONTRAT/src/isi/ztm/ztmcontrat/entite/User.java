package isi.ztm.ztmcontrat.entite;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
public class User implements Serializable {

	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Id
	private int id;
	private String nomUser;
	private Date dateCreation;
	private String prenomUser;
	private String emailUser;
	private String password;
	private String login;
	private String etat;
	private boolean enable;
	private Role role;
	private Profil profil;
	private String cin;
	
	
	
	
	
	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getPrenomUser() {
		return prenomUser;
	}

	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	



	public User(String nomUser, Date dateCreation, String prenomUser, String emailUser, String password, String login,
			String etat, boolean enable, Role role) {
		super();
		this.nomUser = nomUser;
		this.dateCreation = dateCreation;
		this.prenomUser = prenomUser;
		this.emailUser = emailUser;
		this.password = password;
		this.login = login;
		this.etat = etat;
		this.enable = enable;
		this.role = role;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}
   
}
