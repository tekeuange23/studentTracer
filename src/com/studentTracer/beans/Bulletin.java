package com.studentTracer.beans;

import java.util.HashMap;

public class Bulletin {
	private HashMap<Long, Note> notesList;
	private Tuteur tuteur;
	private Eleve eleve;
	private Sequence sequence;
	private Salle salle;
	
	private Long moyenne;
	private Long rang;
	private String mention;
	
	
	public HashMap<Long, Note> getNotesList() {
		return notesList;
	}
	public void setNotesList(HashMap<Long, Note> notesList) {
		this.notesList = notesList;
	}
	public Tuteur getTuteur() {
		return tuteur;
	}
	public void setTuteur(Tuteur tuteur) {
		this.tuteur = tuteur;
	}
	public Eleve getEleve() {
		return eleve;
	}
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	public Sequence getSequence() {
		return sequence;
	}
	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public Long getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(Long moyenne) {
		this.moyenne = moyenne;
	}
	public Long getRang() {
		return rang;
	}
	public void setRang(Long rang) {
		this.rang = rang;
	}
	public String getMention() {
		return mention;
	}
	public void setMention(String mention) {
		this.mention = mention;
	}
	
	
}
