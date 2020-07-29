package com.studentTracer.dao;


import java.io.IOException;
import java.util.ArrayList;

import com.studentTracer.beans.Eleve;

public interface EleveDAO {
	int ajouterEleve(Eleve eleve) throws IOException;
    void supprimerEleve(Long id);
    ArrayList<Eleve> rechercherEleve( Long id, String cle );
    void modifierElève(Eleve eleve, Eleve newEleve);
}
