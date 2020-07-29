package com.studentTracer.daoImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.studentTracer.beans.Tuteur;
import com.studentTracer.dao.DaoFactory;
import com.studentTracer.dao.TuteurDAO;

public class TuteurDAOImpl implements TuteurDAO {
	private DaoFactory daoFactory;
	public TuteurDAOImpl(DaoFactory daoFactory) {
		// TODO Auto-generated constructor stub
		this.daoFactory = daoFactory;
	}
	@Override
	public int ajouterTuteur(Tuteur tuteur) {
		// TODO Auto-generated method stub
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        int index=-1;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO Tuteur(nom_tuteur, prenom_tuteur, sexe, email, telephone, login, password)"
            		+ " VALUES( ?, ?, ?, ?, ? , ?, ?)",Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, tuteur.getNom_tuteur());
            preparedStatement.setString(2, tuteur.getPrenom_tuteur());
            preparedStatement.setString(3, String.valueOf(tuteur.getSexe()));
            preparedStatement.setString(4, tuteur.getEmail());
            preparedStatement.setString(5, tuteur.getNumero_telephone());
            preparedStatement.setString(6, tuteur.getLogin());
            preparedStatement.setString(7, tuteur.getMot_de_passe());

            preparedStatement.executeUpdate();
            
            ResultSet rs= preparedStatement.getGeneratedKeys();
            
            while(rs.next()) {
            System.out.println(rs.getInt(1));
            index=rs.getInt(1);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return index;

		
	}

	@Override
	public void modifierTuteur(Tuteur tuteur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Tuteur> rechercherTuteur(Long id) {

		// TODO Auto-generated method stub
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        Tuteur tuteur =null;
        ArrayList<Tuteur> tuteurs= new ArrayList<Tuteur>();
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();

            resultat = statement.executeQuery("SELECT * FROM Tuteur WHERE id_tuteur="+id+";");
         
            while (resultat.next()) {
            	tuteur=new Tuteur();
            	tuteur.setId_tuteur(resultat.getLong("id_tuteur"));
            	tuteur.setNom_tuteur(resultat.getString("nom_tuteur"));
            	tuteur.setPrenom_tuteur(resultat.getString("prenom_tuteur"));
            	tuteur.setSexe(resultat.getString("sexe").charAt(0));
            	tuteur.setEmail(resultat.getString("email"));
            	tuteur.setNumero_telephone(resultat.getString("telephone"));
            	tuteur.setLogin(resultat.getString("login"));
            	tuteur.setMot_de_passe(resultat.getString("password"));
            	tuteurs.add(tuteur);
            	

            }
        } catch (SQLException e) {
           System.out.println("Impossible de communiquer avec la base de donn�es  /rechercheTuteur"+ e.getMessage());
        } catch (Exception e) { 
        	System.out.println("Mauvais Identifiants!!! "+e.getMessage());
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
            	 System.out.println("Impossible de communiquer avec la base de donn�es");
            }
        }
        return tuteurs;
	}

	

	@Override
	public void supprimerTuteur(Tuteur tuteur) {
		// TODO Auto-generated method stub
		
	}

}
