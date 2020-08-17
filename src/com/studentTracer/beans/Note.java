package com.studentTracer.beans;

import java.sql.Date;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.http.HttpServletRequest;

public class Note {
	private Long id_note;
	private Long note;
	private String appreciation;
	private String date_enregistrement;
	
	private Personnel enseignant;
	private Eleve eleve;
	private Sequence sequence;
	
	//NOT IN NOTE MODEL
	private Long rank;
	private String Mention;
	
	//HANDLING ERRORS VARIABLES
	private static String notesAreValid = "NONE"; //NONE - NO - YES 
	private static String notesAlreadyExist = "NONE"; //NONE - NO - YES 
	
	public static Note initNote(			//AJOUT
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
	
	public static Note initNouvelleNote(		//MODIFICATION
			HttpServletRequest request, 
			Note ancienneNote, 
			Personnel connectedEnseignant, 
			Sequence sequence
	) {
		 Note note = new Note();
		 Long noteValue = null;
		 String appreciationValue = null;
		 try {	
			 System.out.println("Note ID INIT: " + ancienneNote.getId_note());
			 noteValue = (long) Integer.parseInt(request.getParameter("note-" + ancienneNote.getId_note())); 
			 if(noteValue < 0 || noteValue > 20) {
				 Note.setNotesValidityToNo();
			 }
		 } 
		 catch (NumberFormatException e) {
			 e.printStackTrace();
			 Note.setNotesValidityToNo();
		 }
		 appreciationValue = request.getParameter("appreciation-" + ancienneNote.getId_note());
		 
		 note.setId_note(ancienneNote.getId_note());
		 note.setNote(noteValue);
		 note.setAppreciation(appreciationValue);
		 note.setEleve(ancienneNote.getEleve());
		 note.setEnseignant(connectedEnseignant);
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

	public String getDate_enregistrement() {
		return date_enregistrement;
	}

	public void setDate_enregistrement(String date_enregistrament) {
		this.date_enregistrement = date_enregistrament;
	}

	public Personnel getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Personnel enseignant) {
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
	//////////////////////////////////////NOT IN NOTE MODEL
	public Long getRank() {
		return rank;
	}
	public void setRank(Long rank) {
		this.rank = rank;
	}
	public String getMention() {
		return Mention;
	}
	public void setMention() {
		if(this.note == 0) {
			Mention = "NUL";
			return;
		}
		if(this.note < 6) {
			Mention = "M";
			return;
		}
		if(this.note < 10) {
			Mention = "I";
			return;
		}
		if(this.note == 10 || this.note == 11) {
			Mention = "P";
			return;
		}
		if(this.note == 12 || this.note == 13) {
			Mention = "AB";
			return;
		}
		if(this.note == 14 || this.note == 15) {
			Mention = "B";
			return;
		}
		if(this.note == 16 || this.note == 17) {
			Mention = "TB";
			return;
		}
		if(this.note == 18 || this.note == 19) {
			Mention = "EX";
			return;
		}
		if(this.note == 20) {
			Mention = "PF";
			return;
		}
	}
	//////////////////////////////////////////////////////
	

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
