package com.studentTracer.dao;

import com.studentTracer.beans.Censeur;

public interface CenseurDAO {

	void ajouterCenseur(Censeur censeur);
	void modifierCenseur(Censeur censeur);
	void SupprimerCenseur(Censeur censeur);
	Censeur rechercherCenseur(int mat, String cle);
	
}
