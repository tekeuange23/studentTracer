package com.studentTracer.dao;

import com.studentTracer.beans.Abscence;
import com.studentTracer.beans.Eleve;
import com.studentTracer.beans.Plage;

public interface AbscenceDAO {

	int ajouterAbscence(Abscence abs);
	void modifierAbscence(Abscence abs);
	void supprimerAbscence(Abscence abs);
	Abscence rechercherAbscence(Eleve eleve, Plage plage);
}
