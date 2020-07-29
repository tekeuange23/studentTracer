package com.studentTracer.daoImplements;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.studentTracer.beans.Eleve;
import com.studentTracer.dao.DaoFactory;
import com.studentTracer.dao.EleveDAO;

public class EleveDAOImpl implements EleveDAO{
	private DaoFactory daoFactory;
	public EleveDAOImpl(DaoFactory daoFactory) {
		// TODO Auto-generated constructor stub
		this.daoFactory = daoFactory;
	}
	@Override
	public int ajouterEleve(Eleve eleve) throws IOException {

		// TODO Auto-generated method stub
		 Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        int index=-1;
	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO Eleve(nom_eleve, prenom_eleve, sexe, date_naissance, lieu_naissance, email, telephone, login, password, id_classe, id_tuteur, id_salle)"
	            		+ " VALUES(?, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
	            preparedStatement.setString(1, eleve.getNom_eleve());
	            preparedStatement.setString(2, eleve.getPrenom_eleve());
	            preparedStatement.setString(3, String.valueOf(eleve.getSexe()));
	            preparedStatement.setDate(4, eleve.getDate_naissance());
	            preparedStatement.setString(5, eleve.getLieu_de_naissance());
	            preparedStatement.setString(6, eleve.getEmail());
	            preparedStatement.setString(7, eleve.getTelephone());
	            preparedStatement.setString(8, eleve.getLogin());
	            preparedStatement.setString(9, eleve.getMot_de_pass());
	            preparedStatement.setLong(10, eleve.getClasse().getId_class());
	            preparedStatement.setLong(11, eleve.getTuteur().getId_tuteur());
	            preparedStatement.setLong(12, eleve.getNumero_salle());

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
	public ArrayList<Eleve> rechercherEleve(Long id, String cle) {
		// TODO Auto-generated method stub
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        Eleve eleve =null;
        ArrayList<Eleve> eleves=null;
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
           
            resultat = statement.executeQuery("SELECT * FROM Eleve WHERE id_eleve="+id+" OR nom_eleve LIKE '%"+cle+"%' OR prenom_eleve LIKE '%"+cle+"%';");
            eleves=new ArrayList<Eleve>();
            while (resultat.next()) {
            	
            	Long id_eleve= resultat.getLong("id_eleve");
                String nom_eleve = resultat.getString("nom_eleve");
                String prenom_eleve = resultat.getString("prenom_eleve");
                // sexe=resultat.getString("sexe");
                Date date_naissance= resultat.getDate("date_naissance");
                String lieu_naissance=resultat.getString("lieu_naissance");
                String email=resultat.getString("email");
                String mot_de_passe=resultat.getString("password");
                //por la classe , recuperer son id puis la rechercher
                

                
                 eleve = new Eleve();
                eleve.setId_eleve(id_eleve);
                eleve.setNom_eleve(nom_eleve);
                eleve.setPrenom_eleve(prenom_eleve);
                eleve.setDate_naissance(date_naissance);
                eleve.setLieu_de_naissance(lieu_naissance);
                eleve.setMot_de_pass(mot_de_passe);
                eleve.setEmail(email);
                eleves.add(eleve);

            }
        } catch (SQLException e) {
           System.out.println("Impossible de communiquer avec la base de donn�es "+ e.getMessage());
        } catch (Exception e) { 
        	System.out.println("Mauvais Identifiants!!!");
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
        return eleves;
	}

	@Override
	public void supprimerEleve(Long id) {
		// TODO Auto-generated method stub
		Connection connexion = null;
        Statement statement = null;
        ArrayList<Eleve> eleves=null;
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
           
            statement.executeUpdate("DELETE FROM Eleve WHERE id_eleve="+id+";");
            System.out.println("suppresion eleve effetuer");
           
        } catch (SQLException e) {
           System.out.println("Impossible de communiquer avec la base de donn�es "+ e.getMessage());
        } catch (Exception e) { 
        	System.out.println("Mauvais Identifiants!!!");
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
	}


	@Override
	public void modifierElève(Eleve eleve, Eleve newEleve) {

		// TODO Auto-generated method stub
		Long id=eleve.getId_eleve();
		String requete="UPDATE Eleve SET nom_eleve=?, prenom_eleve=?, sexe=?, date_naissance=?, lieu_naissance=?, email=?, telephone=?, login=?, password=?, id_classe=?, id_tuteur=? WHERE id_eleve='"+id+"';";
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(requete);
            //preparedStatement.setLong(1, utilisateur.getId());
            preparedStatement.setString(1, newEleve.getNom_eleve());
            preparedStatement.setString(2, newEleve.getPrenom_eleve());
            preparedStatement.setString(3, String.valueOf(newEleve.getSexe()));
            preparedStatement.setDate(4, newEleve.getDate_naissance());
            preparedStatement.setString(5, newEleve.getLieu_de_naissance());
            preparedStatement.setString(6, newEleve.getEmail());
            preparedStatement.setString(7, newEleve.getTelephone());
            preparedStatement.setString(8, newEleve.getLogin());
            preparedStatement.setString(9, newEleve.getMot_de_pass());
            preparedStatement.setLong(10, newEleve.getClasse().getId_class());
            preparedStatement.setLong(11, newEleve.getTuteur().getId_tuteur());

            preparedStatement.executeUpdate();
           // connexion.commit();
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
                System.out.println("Impossible de communiquer avec la base de donn�es "+ e.getMessage());
                
            }
            
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
            	System.out.println(e.getMessage());
            	System.out.println("Impossible de communiquer avec la base de donn�es");
            }
        }
	}

}
