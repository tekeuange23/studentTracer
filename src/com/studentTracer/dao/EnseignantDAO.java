package com.studentTracer.dao;

import com.studentTracer.beans.Enseignant;

public interface EnseignantDAO {
 void ajouterEnseignant(Enseignant enseignant);
 void modifierEnseignant(Enseignant enseignant);
 void supprimerEnseignant(Enseignant enseignant);
 Enseignant rechercherEnseignant(int mat, String cle);
}
