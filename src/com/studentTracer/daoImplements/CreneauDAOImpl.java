package com.studentTracer.daoImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.studentTracer.beans.CreneauHoraire;
import com.studentTracer.dao.CreneauHoraireDAO;
import com.studentTracer.dao.DaoFactory;

public class CreneauDAOImpl implements CreneauHoraireDAO{
	private DaoFactory daoFactory;
	public CreneauDAOImpl(DaoFactory daoFactory) {
		// TODO Auto-generated constructor stub
		this.daoFactory = daoFactory;
	}
	@Override
	public void ajouterCreneauHoraire(CreneauHoraire creneauH) {
		// TODO Auto-generated method stub
		 Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	       
	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO CreneauHoraire(id_creneau, id_eleve)"
	            		+ " VALUES(?, ?)",Statement.RETURN_GENERATED_KEYS);
//	            preparedStatement.setLong(1,abs.getCreaneauHoraire().getId_creneau());
//	            preparedStatement.setLong(2, abs.getEleve().getId_eleve());

	            preparedStatement.executeUpdate();
	            
	            ResultSet rs= preparedStatement.getGeneratedKeys();
	            
	            while(rs.next()) {
	            System.out.println(rs.getInt(1));
	           // index=rs.getInt(1);
	            System.out.println("Insertion Abscence terminée / id courant: "+rs);
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

		
	}

	@Override
	public void ModifierCreneauHoraire(CreneauHoraire creneauH) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerCreneauHoraire(CreneauHoraire creneauH) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CreneauHoraire rechercherCreneauHoraire(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
