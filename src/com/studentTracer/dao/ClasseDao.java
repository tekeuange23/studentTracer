package com.studentTracer.dao;

import java.util.ArrayList;

import com.studentTracer.beans.Classe;
import com.studentTracer.beans.Eleve;

public interface ClasseDao {

	public Classe rechercherClasse(String id_classe);
	public ArrayList<Eleve> listeEleve(Long id);
}
