package com.studentTracer.dao;

import com.studentTracer.beans.CommunicationST;

public interface CommunicationSTDAO {

	void ajouterComEE(CommunicationST comEE);
	void modifierComEE(CommunicationST comEE);
	void supprimerComEE(CommunicationST comEE);
	CommunicationST rechercherComEE(int id, String cle);
}
