package com.studentTracer.daoImplements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.studentTracer.beans.Classe;
import com.studentTracer.beans.Salle;
import com.studentTracer.beans.Sequence;
import com.studentTracer.dao.DaoFactory;
import com.studentTracer.dao.SequenceDAO;

public class SequenceDAOImpl implements SequenceDAO{
	private DaoFactory daoFactory;
	public SequenceDAOImpl(DaoFactory daoFactory) {
		// TODO Auto-generated constructor stub
		this.daoFactory = daoFactory;
	}
	@Override
	public HashMap<Long, Sequence> rechercherSequences() {
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        Sequence seq = null;
        HashMap<Long, Sequence> sequences = null;
        
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
           
            resultat = statement.executeQuery(" SELECT S.*"
            								 +"	FROM Sequences S" + ";");
            sequences = new HashMap<Long, Sequence>();
            while (resultat.next()) {
            	Long id_seq = resultat.getLong("S.id_sequence");
                String libelle_seq = resultat.getString("S.libelle_sequence");
                
                seq = new Sequence();
                seq.setId(id_seq);
                seq.setLibelle(libelle_seq);
                
                sequences.put(id_seq, seq);
            }
            
        } catch (SQLException e) {
            System.out.println("Exception venant de la base de donn�es "+ e.getMessage());
        } catch (Exception e) { 
         	System.out.println("Autre Exception" + e.getMessage());
        }
        finally {
        	try {
        		if (connexion != null) {
        				connexion.close();  
                }
        	} catch (SQLException e) {
        		System.out.println("Exception venant de la base de donn�es: a la fermeture "+ e.getMessage());
            }
        }
        
		return sequences;
	}
}
