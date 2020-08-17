package com.studentTracer.beans;

public class CommunicationEE {
	private Long id_comEE;
	private String date;
	private String message;
	
	private Enseignant enseignant;
	private Eleve eleve;
	private Salle salle;
	
	
	public Long getId_comEE() {
		return id_comEE;
	}
	public void setId_comEE(Long id_comEE) {
		this.id_comEE = id_comEE;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Eleve getEleve() {
		return eleve;
	}
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
}