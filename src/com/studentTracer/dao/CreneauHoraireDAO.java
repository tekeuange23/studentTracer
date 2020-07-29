package com.studentTracer.dao;

import com.studentTracer.beans.CreneauHoraire;

public interface CreneauHoraireDAO {

	void ajouterCreneauHoraire(CreneauHoraire creneauH);
	void ModifierCreneauHoraire(CreneauHoraire creneauH);
	void supprimerCreneauHoraire(CreneauHoraire creneauH);
	CreneauHoraire rechercherCreneauHoraire(int id);
}
