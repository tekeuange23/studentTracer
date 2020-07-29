package com.studentTracer.beans;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import com.studentTracer.dao.ClasseDao;
import com.studentTracer.dao.TuteurDAO;

public class Tuteur {
	private Long id_tuteur;
	private String nom_tuteur;
	private String prenom_tuteur;
	private String numero_telephone;
	private String login;
	private String mot_de_passe;
	private char sexe;
	private String email;
	
	
	 public Tuteur initTuteur(HttpServletRequest request) {
		 Tuteur tuteur=new Tuteur();
		 
		 tuteur.setNom_tuteur(request.getParameter("nom_tuteur"));
		 
		 tuteur.setPrenom_tuteur(request.getParameter("prenom_tuteur"));
		 tuteur.setSexe(request.getParameter("sexe_tuteur").charAt(0));
		 tuteur.setEmail(request.getParameter("email_tuteur"));
		 tuteur.setNumero_telephone(request.getParameter("telephone_tuteur"));
		 tuteur.setLogin("login");
		 tuteur.setMot_de_passe("login");

		 System.out.println("initialisation Tuteur Terminé");
		 return tuteur;

	 }
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getSexe() {
		return sexe;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	public Long getId_tuteur() {
		return id_tuteur;
	}
	public void setId_tuteur(Long id_tuteur) {
		this.id_tuteur = id_tuteur;
	}
	public String getNom_tuteur() {
		return nom_tuteur;
	}
	public void setNom_tuteur(String nom_tuteur) {
		this.nom_tuteur = nom_tuteur;
	}
	public String getPrenom_tuteur() {
		return prenom_tuteur;
	}
	public void setPrenom_tuteur(String prenom_tuteur) {
		this.prenom_tuteur = prenom_tuteur;
	}
	public String getNumero_telephone() {
		return numero_telephone;
	}
	public void setNumero_telephone(String numero_telephone) {
		this.numero_telephone = numero_telephone;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	

}
