package com.studentTracer.dao;

import com.studentTracer.beans.CommuniicationEE;

public interface CommunicationEEDAO {

	void ajouterComEE(CommuniicationEE comEE);
	void modifierComEE(CommuniicationEE comEE);
	void supprimerComEE(CommuniicationEE comEE);
	CommuniicationEE rechercherComEE(int id, String cle);
}
