package com.studentTracer.dao;

import com.studentTracer.beans.Surveillant;

public interface SurveillantDAO {

	void ajouterSurveillant(Surveillant surveillant);
	void modifierSurveillant(Surveillant surveillant);
	void supprimerSurveillant(Surveillant surveillant);
	Surveillant rechercherSurveillant(int id, String cle);
}
