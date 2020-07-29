package com.studentTracer.beans;

import java.sql.Date;

public class Note {
	private int id_note;
	private String note;
	private String appreciation;
	private Date date_enregistrament;
	
	private Enseignant enseignant;
	private Eleve eleve;
	private Sequence sequence;

}
