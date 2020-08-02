package com.studentTracer.beans;

import java.sql.Date;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.http.HttpServletRequest;

public class Note {
	private Long id_note;
	private Long note;
	private String appreciation;
	private Date date_enregistrement;
	
	private Enseignant enseignant;
	private Eleve eleve;
	private Sequence sequence;
	
	//HANDLING ERRORS VARIABLES
	private static String notesAreValid = "NONE"; //NONE - NO - YES 
	private static String notesAlreadyExist = "NONE"; //NONE - NO - YES 
	
	public static Note initNote(
			HttpServletRequest request, 
			Eleve eleve, 
			Enseignant enseignant, 
			Sequence sequence
	) {
		 Note note = new Note();
		 Long noteValue = null;
		 String appreciationValue = null;
		 try {	
			 noteValue = (long) Integer.parseInt(request.getParameter("note-" + eleve.getId_eleve())); 
			 if(noteValue < 0 || noteValue > 20) {
				 Note.setNotesValidityToNo();
			 }
		 } 
		 catch (NumberFormatException e) {
			 e.printStackTrace();
			 Note.setNotesValidityToNo();
		 }
		 appreciationValue = request.getParameter("appreciation-" + eleve.getId_eleve());
		 
		 note.setNote(noteValue);
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

	

	//HANDLING ERRORS VARIABLES
	public static String getNotesValidity() {
		return notesAreValid;
	}
	public static void setNotesValidityToNone() {
		Note.notesAreValid = "NONE";
	}
	public static void setNotesValidityToNo() {
		Note.notesAreValid = "NO";
	}
	public static void setNotesValidityToYes() {
		Note.notesAreValid = "YES";
	}

	public static String getNotesExistancy() {
		return notesAlreadyExist;
	}
	public static void setNotesExistancyToNone() {
		Note.notesAlreadyExist = "NONE";
	}
	public static void setNotesExistancyToNo() {
		Note.notesAlreadyExist = "NO";
	}
	public static void setNotesExistancyToYes() {
		Note.notesAlreadyExist = "YES";
	}
	
	
	
}
