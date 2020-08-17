package com.studentTracer.dao;

import java.util.HashMap;

import com.studentTracer.beans.CommunicationEE;
import com.studentTracer.beans.Eleve;
import com.studentTracer.beans.Enseignant;
import com.studentTracer.beans.Salle;

public interface CommunicationEEDAO {

	public void addEnseignantMessage(Enseignant enseignant, Salle salle, String message);
	void modifierComEE(CommunicationEE comEE);
	void supprimerComEE(CommunicationEE comEE);
	CommunicationEE rechercherComEE(int id, String cle);
	HashMap<Long, CommunicationEE> getAllMessages(Enseignant connectedEnseignant, HashMap<Long, Eleve> elevesSalle, Salle salle);
}
