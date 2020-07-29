package com.studentTracer.beans;

import java.sql.Date;

public class CreneauHoraire {
	private int id_creneau;
	private Date date_fiche;
	private Plage plage;
	
	public int getId_creneau() {
		return id_creneau;
	}
	public void setId_creneau(int id_creneau) {
		this.id_creneau = id_creneau;
	}
	public Date getDate_fiche() {
		return date_fiche;
	}
	public void setDate_fiche(Date date_fiche) {
		this.date_fiche = date_fiche;
	}
	public Plage getPlage() {
		return plage;
	}
	public void setPlage(Plage plage) {
		this.plage = plage;
	}
	
	
	
}
 