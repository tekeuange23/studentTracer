package com.studentTracer.beans;

import java.util.ArrayList;

public class Salle {
	private Long id;
	private String libelle;
	private Classe classe;
	private ArrayList<Eleve> eleves;

	public Long getId() {
		return this.id;
	}
	public String getLibelle() {
		return this.libelle;
	}
	public Classe getClasse() {
		return this.classe;
	}
	public ArrayList<Eleve> getEleves() {
		return this.eleves;
	}
	
	
	
	public void setId(Long numero) {
		this.id = numero;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public void setLEleves(ArrayList<Eleve> eleves) {
		this.eleves = eleves;
	}

}
