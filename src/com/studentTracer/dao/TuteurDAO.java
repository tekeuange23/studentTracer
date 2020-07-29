package com.studentTracer.dao;

import java.util.ArrayList;

import com.studentTracer.beans.Tuteur;

public interface TuteurDAO {

	int ajouterTuteur(Tuteur tuteur);
	void modifierTuteur(Tuteur tuteur);
	ArrayList<Tuteur> rechercherTuteur(Long id);
	void supprimerTuteur(Tuteur tuteur);
}
