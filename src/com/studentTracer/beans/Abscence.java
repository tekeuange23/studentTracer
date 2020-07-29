package com.studentTracer.beans;

public class Abscence {
	private Long id_abscence;
	private CreneauHoraire creaneauHoraire;
	private Eleve eleve;


	public Long getId_abscence() {
		return id_abscence;
	}
	public void setId_abscence(Long id_abscence) {
		this.id_abscence = id_abscence;
	}
	public CreneauHoraire getCreaneauHoraire() {
		return creaneauHoraire;
	}
	public void setCreaneauHoraire(CreneauHoraire creaneauHoraire) {
		this.creaneauHoraire = creaneauHoraire;
	}
	public Eleve getEleve() {
		return eleve;
	}
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
}
