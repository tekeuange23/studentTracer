package com.studentTracer.daoImplements;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.studentTracer.beans.Classe;
import com.studentTracer.beans.Eleve;
import com.studentTracer.dao.ClasseDao;
import com.studentTracer.dao.DaoFactory;

public class ClasseDAOImpl implements ClasseDao{
	private DaoFactory daoFactory;
	public ClasseDAOImpl(DaoFactory daoFactory) {
		// TODO Auto-generated constructor stub
		this.daoFactory = daoFactory;
	}
	@Override
	public Classe rechercherClasse(String id_classe) {


		// TODO Auto-generated method stub
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        Classe classe =null;
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
           
            resultat = statement.executeQuery("SELECT * FROM Classe WHERE libelle_classe='"+id_classe+"';");
         
            while (resultat.next()) {
            	
            	Long id= resultat.getLong("id_classe");
                String libelle_classe = resultat.getString("libelle_classe");
                

                
                 classe = new Classe();
                classe.setId_class(id);
                classe.setLibelle(libelle_classe);;

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
        return classe;
	}
	@Override
	public ArrayList<Eleve> listeEleve(Long id) {
		// TODO Auto-generated method 
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        Eleve eleve =null;
        ArrayList<Eleve> eleves=new ArrayList<Eleve>();
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
           
            resultat = statement.executeQuery("SELECT id_eleve, nom_eleve, prenom_eleve ,sexe FROM Classe C, Eleve E WHERE E.id_classe="+id+" AND C.id_classe=E.id_classe;");
         
            while (resultat.next()) {
            	eleve=new Eleve();
            	eleve.setId_eleve(Long.parseLong(resultat.getString("id_eleve")));
            	eleve.setNom_eleve(resultat.getString("nom_eleve"));
            	eleve.setPrenom_eleve(resultat.getString("prenom_eleve"));
            	eleve.setSexe(resultat.getString("sexe").charAt(0));
            	
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

}
