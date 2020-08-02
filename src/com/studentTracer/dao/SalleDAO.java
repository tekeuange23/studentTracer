package com.studentTracer.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.studentTracer.beans.Eleve;
import com.studentTracer.beans.Salle;

public interface SalleDAO {
	HashMap<Long, Salle> rechercheSallesParIdEnseignant( Long idEns );
	HashMap<Long, Eleve> rechercheElevesParIdSalle( Long idSal );
}
