package com.studentTracer.dao;

import com.studentTracer.beans.Note;

public interface NoteDAO {

	void AjouterNote(Note note);
	void modifierNote(Note note);
	void supprimerNote(Note note);
	Note rechercherNote(int id, String cle);
}
