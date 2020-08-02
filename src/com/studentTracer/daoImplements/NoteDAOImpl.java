package com.studentTracer.daoImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.studentTracer.beans.Note;
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
	public void EnregistrerNote(Note note) {
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
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
}
