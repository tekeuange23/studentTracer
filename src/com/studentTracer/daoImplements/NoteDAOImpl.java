package com.studentTracer.daoImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.HashMap;

import com.studentTracer.beans.Classe;
import com.studentTracer.beans.Eleve;
import com.studentTracer.beans.Note;
import com.studentTracer.beans.Personnel;
import com.studentTracer.beans.Salle;
import com.studentTracer.beans.Sequence;
import com.studentTracer.beans.Tuteur;
import com.studentTracer.dao.DaoFactory;
import com.studentTracer.dao.NoteDAO;

public class NoteDAOImpl implements NoteDAO{
	private DaoFactory daoFactory;
	public NoteDAOImpl(DaoFactory daoFactory) {
		// TODO Auto-generated constructor stub
		this.daoFactory = daoFactory;
	}

	@Override
	public void addNote(Note note) {
		if(note == null) {
			return;
		}
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(" INSERT INTO Note"
            											  +" VALUES( NULL, ?, ?, NOW(), ?, ?, ?)",
            											  Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong  (1, note.getNote());
            preparedStatement.setString(2, note.getAppreciation());
            preparedStatement.setLong  (3, note.getEnseignant().getId());
            preparedStatement.setLong  (4, note.getEleve().getId_eleve());
            preparedStatement.setLong  (5, note.getSequence().getId());

            preparedStatement.executeUpdate();
            
            //Note.setNotesValidityToYes(); //l'ajout a bien marcher alors les notes ont etes enregistres avec success
            
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            Note.setNotesExistancyToYes();   //contraintes d'unicites de la note  non respectes: alors les notes existe deja
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public void modifyNote(Note initialNote, Note finalNote) {
		if(finalNote == null) {
			System.out.println("NULL");
			return;
		}
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(" UPDATE Note"
														  +" SET note = ? ,"
														  +"  	 appreciation = ? ,"
														  +"  	 date_enregistrement = NOW()"
														  +" WHERE id_note = ?",
            											  Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong  (1, finalNote.getNote());
            preparedStatement.setString(2, finalNote.getAppreciation());
            preparedStatement.setLong  (3, initialNote.getId_note());

            preparedStatement.executeUpdate();
            
            //Note.setNotesValidityToYes(); //l'ajout a bien marcher alors les notes ont etes enregistres avec success
            
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public HashMap<Long, Note> getNotesList(Personnel personnel, Salle salle, Sequence sequence) {
		
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        Note note = null;
        HashMap<Long, Note> notes = null;
        
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
           
            resultat = statement.executeQuery( " SELECT N.*, EL.*,"
            								 + " DATE_FORMAT(N.date_enregistrement,"
            								 + "			'%d %b. %y - %r') AS dateEnregis"
            								 +"	FROM Note N"
            								 +"	INNER JOIN Personnel P"
            								 +"		ON N.id_personnel = P.id_personnel"
            								 +"	INNER JOIN Sequences S"
            								 +"		ON N.id_sequence = S.id_sequence"
            								 +"	INNER JOIN Eleve EL"
            								 +"		ON N.id_eleve = EL.id_eleve"
											 +"	INNER JOIN CreneauHoraire ch"
											 +"		ON ch.id_personnelEns = P.id_personnel"
											 +"	INNER JOIN Salle SA"
											 +"		ON ch.id_salle = SA.id_salle"
											 +"    AND EL.id_salle = SA.id_salle"
            								 +" WHERE P.id_personnel = " + personnel.getId() 
            								 +"   AND SA.id_salle = " 	 + salle.getId() 
            								 +"   AND S.id_sequence = "  + sequence.getId() + ";");
            
            notes = new HashMap<Long, Note>();
            
            while (resultat.next()) {
            	Long id_note 		 = resultat.getLong("N.id_note");
            	Long noteValue  	 = resultat.getLong("N.note");
                String appreciation  = resultat.getString("N.appreciation");
                String date		     = resultat.getString("dateEnregis");
                Eleve e = new Eleve();
                	Long id_eleve 		= resultat.getLong("EL.id_eleve");
                	String nom_eleve 	= resultat.getString("EL.nom_eleve");
                	String prenom_eleve = resultat.getString("EL.prenom_eleve");
                	String photo_eleve 	= resultat.getString("EL.photo_url");
                	e.setId_eleve(id_eleve);
                	e.setNom_eleve(nom_eleve);
                	e.setPrenom_eleve(prenom_eleve);
                	e.setPhoto_url(photo_eleve);
                note = new Note();
                note.setId_note(id_note);
                note.setNote(noteValue);
                note.setAppreciation(appreciation);
                note.setDate_enregistrement(date);
                note.setEleve(e);
                note.setEnseignant(personnel);
                note.setSequence(sequence);
                
                notes.put(id_note, note);
            }
            
        } catch (SQLException e) {
            System.out.println("Exception venant de la base de donn�es "+ e.getMessage());
        } catch (Exception e) { 
         	System.out.println("Autre Exception : " + e.getMessage());
         	e.printStackTrace();
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
        
		return notes;
	}
	
}
