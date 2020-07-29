package com.studentTracer.daoImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.studentTracer.beans.Abscence;
import com.studentTracer.beans.Eleve;
import com.studentTracer.beans.Plage;
import com.studentTracer.dao.AbscenceDAO;
import com.studentTracer.dao.DaoFactory;

public class AbscenseDAOImpl implements AbscenceDAO {
	private DaoFactory daoFactory;
	public AbscenseDAOImpl(DaoFactory daoFactory) {
		// TODO Auto-generated constructor stub
		this.daoFactory = daoFactory;
	}
	@Override
	public int ajouterAbscence(Abscence abs) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		 Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        int index=-1;
	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO Abscense(id_creneau, id_eleve)"
	            		+ " VALUES(?, ?)",Statement.RETURN_GENERATED_KEYS);
	            preparedStatement.setLong(1,abs.getCreaneauHoraire().getId_creneau());
	            preparedStatement.setLong(2, abs.getEleve().getId_eleve());

	            preparedStatement.executeUpdate();
	            
	            ResultSet rs= preparedStatement.getGeneratedKeys();
	            
	            while(rs.next()) {
	            System.out.println(rs.getInt(1));
	            index=rs.getInt(1);
	            System.out.println("Insertion Abscence terminée / id courant: "+rs);
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return index;
		
	}

	@Override
	public void modifierAbscence(Abscence abs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerAbscence(Abscence abs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Abscence rechercherAbscence(Eleve eleve, Plage plage) {
		// TODO Auto-generated method stub
		return null;
	}

}
