package com.studentTracer.beans;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

public class Note {
	private Long id_note;
	private Long note;
	private String appreciation;
	private Date date_enregistrement;
	
	private Enseignant enseignant;
	private Eleve eleve;
	private Sequence sequence;
	
	public static Note initNote(HttpServletRequest request, Eleve eleve, Enseignant enseignant, Sequence sequence) {
		 Note note = new Note();
		 
		 Long noteValue = Long.parseLong(request.getParameter("note-" + eleve.getId_eleve()));
		 String appreciationValue = request.getParameter("appreciation-" + eleve.getId_eleve());
		 
		 note.setId_note(noteValue);
		 note.setAppreciation(appreciationValue);
		 note.setEleve(eleve);
		 note.setEnseignant(enseignant);
		 note.setSequence(sequence);
		 
		 return note;
	}

	public Long getId_note() {
		return id_note;
	}

	public void setId_note(Long id_note) {
		this.id_note = id_note;
	}

	public Long getNote() {
		return note;
	}

	public void setNote(Long note) {
		this.note = note;
	}

	public String getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}

	public Date getDate_enregistrement() {
		return date_enregistrement;
	}

	public void setDate_enregistrement(Date date_enregistrament) {
		this.date_enregistrement = date_enregistrament;
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

	public Sequence getSequence() {
		return sequence;
	}

	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}
	
	
	
}
