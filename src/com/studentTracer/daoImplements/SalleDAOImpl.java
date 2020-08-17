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
import com.studentTracer.beans.MatiereClasse;
import com.studentTracer.beans.Salle;
import com.studentTracer.beans.Specialite;
import com.studentTracer.dao.DaoFactory;
import com.studentTracer.dao.SalleDAO;

public class SalleDAOImpl implements SalleDAO{
	private DaoFactory daoFactory;
	public SalleDAOImpl(DaoFactory daoFactory) {
		// TODO Auto-generated constructor stub
		this.daoFactory = daoFactory;
	}
	
	@Override
	public HashMap<Long, Salle> getSallesByIdEnseignant(Long idEns) {
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        Salle salle = null;
        HashMap<Long, Salle> salles = null;
        
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
           
            resultat = statement.executeQuery(" SELECT distinct S.id_salle , C.id_classe, C.libelle_classe , S.numero_salle"
            								 +"	FROM CreneauHoraire ch"
            								 +"	INNER JOIN Personnel P"
            								 +"		ON ch.id_personnelEns = P.id_personnel"
            								 +"	INNER JOIN Salle S"
            								 +"		ON ch.id_salle = S.id_salle"
											 +"	INNER JOIN Classe C"
											 +"		ON C.id_classe = S.id_classe"
            								 +" WHERE ch.id_personnelEns = " + idEns + ";");
            salles=new HashMap<Long, Salle>();
            while (resultat.next()) {
            	Long id_salle = resultat.getLong("S.id_salle");
                String libelle_salle = resultat.getString("S.numero_salle");
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
	public HashMap<Long, Eleve> getSalleByIdSalle(Long idSal) {
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

	@Override
	public HashMap<Long, MatiereClasse> getMatieresSalleByIdEleve(Long id_eleve) {
		System.out.println("DEBUT" + id_eleve);
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        MatiereClasse matSalle = null;
        HashMap<Long, MatiereClasse> matieresSalles = null;
        
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
           
            resultat = statement.executeQuery(" SELECT *"
            								 +"	FROM MatiereClasse mc"
            								 +"	INNER JOIN Specialite sp"
            								 +"		ON mc.id_specialite = sp.id_specialite"
            								 +"	INNER JOIN Classe cl"
            								 +"		ON mc.id_classe = cl.id_classe"
											 +"	INNER JOIN Salle sa"
											 +"		ON cl.id_classe = sa.id_classe"
											 +"	INNER JOIN Eleve el"
											 +"		ON sa.id_salle = el.id_salle"
            								 +" WHERE el.id_eleve = " + id_eleve + ";");
           
            matieresSalles = new HashMap<Long, MatiereClasse>();
            
            while (resultat.next()) {
            	Long id_matSalle = resultat.getLong("mc.id_matiere_classe");
                Classe classe = new Classe();
                	Long id_classe = resultat.getLong("cl.id_classe");						classe.setId_class(id_classe);
                    String libelle_classe = resultat.getString("cl.libelle_classe");		classe.setLibelle(libelle_classe);
                Specialite sp = new Specialite();
                	Long id_sp = resultat.getLong("sp.id_specialite");						sp.setId(id_sp);
                	String nom_specialite = resultat.getString("sp.nom_specialite");		sp.setNom(nom_specialite);
                
                matSalle = new MatiereClasse();
                matSalle.setId(id_matSalle);
                matSalle.setClasse(classe);
                matSalle.setSpecialite(sp);
                
                matieresSalles.put(id_matSalle, matSalle);
                
                System.out.println("Specilite I : " + sp.getNom());
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
        
		return matieresSalles;
	}

}
