package com.studentTracer.daoImplements;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.studentTracer.beans.Classe;
import com.studentTracer.beans.Eleve;
import com.studentTracer.beans.Salle;
import com.studentTracer.dao.DaoFactory;
import com.studentTracer.dao.SalleDAO;

public class SalleDAOImpl implements SalleDAO{
	private DaoFactory daoFactory;
	public SalleDAOImpl(DaoFactory daoFactory) {
		// TODO Auto-generated constructor stub
		this.daoFactory = daoFactory;
	}
	
	@Override
	public HashMap<Long, Salle> rechercheSallesParIdEnseignant(Long idEns) {
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        Salle salle = null;
        HashMap<Long, Salle> salles = null;
        
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
           
            resultat = statement.executeQuery(" SELECT S.id_salle, S.libelle_salle, C.id_classe, C.libelle_classe"
            								 +"	FROM Enseigner E"
            								 +"	INNER JOIN Personnel P"
            								 +"		ON E.id_personnel = P.id_personnel"
            								 +"	INNER JOIN Salle S"
            								 +"		ON E.id_salle = S.id_salle"
											 +"	INNER JOIN Classe C"
											 +"		ON C.id_classe = S.id_classe"
            								 +" WHERE E.id_personnel = " + idEns + ";");
            salles=new HashMap<Long, Salle>();
            while (resultat.next()) {
            	Long id_salle = resultat.getLong("S.id_salle");
                String libelle_salle = resultat.getString("S.libelle_salle");
                Classe classe = new Classe();
                	Long id_classe = resultat.getLong("C.id_classe");
                    String libelle_classe = resultat.getString("C.libelle_classe");
                
                salle = new Salle();
                salle.setId(id_salle);
                salle.setLibelle(libelle_salle);
                	classe.setId_class(id_classe);
                	classe.setLibelle(libelle_classe);
                salle.setClasse(classe);
                
                salles.put(id_salle, salle);
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
        
		return salles;
	}

	@Override
	public HashMap<Long, Eleve> rechercheElevesParIdSalle(Long idSal) {
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        Eleve eleve = null;
        HashMap<Long, Eleve> eleves = null;
        
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
           
            resultat = statement.executeQuery(" SELECT E.*"
            								 +"	FROM Eleve E"
            								 +"	INNER JOIN Salle S"
            								 +"		ON E.id_salle = S.id_salle"
            								 +" WHERE E.id_salle = " + idSal + ";");
            eleves = new HashMap<Long, Eleve>();
            while (resultat.next()) {
            	Long id_eleve = resultat.getLong("E.id_eleve");
                String nom_eleve = resultat.getString("E.nom_eleve");
                String prenom_eleve = resultat.getString("E.prenom_eleve");
                String photo_eleve = resultat.getString("E.photo_url");
                
                eleve = new Eleve();
                eleve.setId_eleve(id_eleve);
                eleve.setNom_eleve(nom_eleve);
                eleve.setPrenom_eleve(prenom_eleve);
                
                eleves.put(id_eleve,eleve);
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
        
		return eleves;
	}

}
