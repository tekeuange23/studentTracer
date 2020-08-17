package com.studentTracer.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.studentTracer.beans.Eleve;
import com.studentTracer.beans.MatiereClasse;
import com.studentTracer.beans.Salle;

public interface SalleDAO {
	HashMap<Long, Salle> getSallesByIdEnseignant( Long idEns );
	HashMap<Long, Eleve> getSalleByIdSalle( Long idSal );
	
	HashMap<Long, MatiereClasse> getMatieresSalleByIdEleve(Long id_eleve);
}
