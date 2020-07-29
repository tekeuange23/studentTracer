package com.studentTracer.beans;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import com.studentTracer.dao.ClasseDao;
import com.studentTracer.dao.TuteurDAO;

public class Eleve {
	 private Long id_eleve;
	 private String nom_eleve;
	 private String prenom_eleve;
	 private char sexe;
	 private Date date_naissance;
	 private String email;
	 private String telephone;

	 private Tuteur tuteur;
	 private Classe classe;
	 private Long numero_salle;
	 
	 public Eleve initEleve(HttpServletRequest request, ClasseDao classeDAO , TuteurDAO tuteurDAO, int id_tuteur) {
		 Eleve eleve=new Eleve();
		 eleve.setNom_eleve(request.getParameter("nom_eleve"));
		 eleve.setPrenom_eleve(request.getParameter("prenom_eleve"));
		 eleve.setSexe(request.getParameter("sexe").charAt(0));
		 eleve.setDate_naissance(Date.valueOf((request.getParameter("date_naissance"))));
		 eleve.setLieu_de_naissance(request.getParameter("lieu_naissance"));
		 eleve.setEmail(request.getParameter("email_eleve"));
		 eleve.setTelephone(request.getParameter("telephone"));
		 eleve.setMot_de_pass("password");
		 eleve.setLogin("login");
		eleve.setClasse(classeDAO.rechercherClasse(request.getParameter("libelle_classe")));
		
		 eleve.setTuteur(tuteurDAO.rechercherTuteur((long)id_tuteur).get(0));
		 eleve.setNumero_salle(Long.parseLong(request.getParameter("numero_salle")));
		 
		 System.out.println("innitialisation eleve terminé");
		return eleve;
	 }
	 public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String login;
	 private String mot_de_pass;
	 private String lieu_de_naissance;
	 
	public Long getId_eleve() {
		return id_eleve;
	}
	public void setId_eleve(Long id_eleve) {
		this.id_eleve = id_eleve;
	}
	public String getNom_eleve() {
		return nom_eleve;
	}
	public void setNom_eleve(String nom_eleve) {
		this.nom_eleve = nom_eleve;
	}
	public String getPrenom_eleve() {
		return prenom_eleve;
	}
	public void setPrenom_eleve(String prenom_eleve) {
		this.prenom_eleve = prenom_eleve;
	}
	public char getSexe() {
		return sexe;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMot_de_pass() {
		return mot_de_pass;
	}
	public void setMot_de_pass(String mot_de_pass) {
		this.mot_de_pass = mot_de_pass;
	}
	public String getLieu_de_naissance() {
		return lieu_de_naissance;
	}
	public void setLieu_de_naissance(String lieu_de_naissance) {
		this.lieu_de_naissance = lieu_de_naissance;
	}
	public Tuteur getTuteur() {
		return tuteur;
	}
	public void setTuteur(Tuteur tuteur) {
		this.tuteur = tuteur;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Long getNumero_salle() {
		return numero_salle;
	}
	public void setNumero_salle(long numero_salle) {
		this.numero_salle = numero_salle;
	}
	
	 

}
