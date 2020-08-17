package com.studentTracer.dao;

import java.util.HashMap;

import com.studentTracer.beans.Note;
import com.studentTracer.beans.Personnel;
import com.studentTracer.beans.Salle;
import com.studentTracer.beans.Sequence;

public interface NoteDAO {

	void addNote(Note note);
	void modifyNote(Note initialNote, Note finalNote);
	HashMap<Long, Note> getNotesList(Personnel personnel, Salle salle, Sequence sequence);
}
