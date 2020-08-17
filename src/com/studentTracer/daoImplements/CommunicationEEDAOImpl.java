package com.studentTracer.daoImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.studentTracer.beans.CommunicationEE;
import com.studentTracer.beans.Eleve;
import com.studentTracer.beans.Enseignant;
import com.studentTracer.beans.Note;
import com.studentTracer.beans.Salle;
import com.studentTracer.dao.CommunicationEEDAO;
import com.studentTracer.dao.DaoFactory;

public class CommunicationEEDAOImpl implements CommunicationEEDAO {

	private DaoFactory daoFactory;

	public CommunicationEEDAOImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void addEnseignantMessage(Enseignant enseignant, Salle salle, String message) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(" INSERT INTO CommunicationEE "
            											  +" VALUES( NULL, ?, NULL, NULL, ?, NOW(), ?)" ,Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setLong  (1, enseignant.getId());
            preparedStatement.setLong  (2, salle.getId());
            preparedStatement.setString(3, message);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void modifierComEE(CommunicationEE comEE) {
		
	}

	@Override
	public void supprimerComEE(CommunicationEE comEE) {
		
	}

	@Override
	public CommunicationEE rechercherComEE(int id, String cle) {
		return null;
	}
	
	@Override
	public HashMap<Long, CommunicationEE> getAllMessages(Enseignant connectedEnseignant, HashMap<Long, Eleve> elevesSalle, Salle salle) {
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        CommunicationEE comEE = null;
        HashMap<Long, CommunicationEE> messages = null;
        
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
           
            resultat = statement.executeQuery(" SELECT c.*, e.*, p.*, s.*, DATE_FORMAT(c.date_envoi, '%d %b. %y - %r') AS dateEnv"
            								 +"	FROM studentTracer.CommunicationEE AS c"
            								 +"	LEFT JOIN (select * from Personnel natural join Role where libelle_role = 'enseignant') as p"
            								 +"		ON c.id_personnel = p.id_personnel"
            								 +"	LEFT JOIN Eleve e"
            								 +"		ON c.id_eleve = e.id_eleve"
            								 +"	INNER JOIN Salle s"
            								 +"		ON c.id_salleCom = s.id_salle"
											 +"	WHERE ( p.id_personnel = " + connectedEnseignant.getId()
											 +"				OR "
											 +"			e.id_eleve IN    " +(elevesSalle.size() > 0 ? this.getInListEleve(elevesSalle) : "(NULL)")
											 +"       )"
											 +"		AND s.id_salle =     " + salle.getId()           +          ";");
            
            messages = new HashMap<Long, CommunicationEE>();
            
            while (resultat.next()) {
            	Long id_cee 	= resultat.getLong("c.id_cee");
                String message  = resultat.getString("c.message");
                String date		= resultat.getString("dateEnv");
                Eleve e = new Eleve();
                	Long id_eleve 		= resultat.getLong("e.id_eleve");			e.setId_eleve(id_eleve);
                	String nom_eleve 	= resultat.getString("e.nom_eleve");		e.setNom_eleve(nom_eleve);
                	String prenom_eleve = resultat.getString("e.prenom_eleve");		e.setPrenom_eleve(prenom_eleve);
                	String photo_eleve 	= resultat.getString("e.photo_url");		e.setPhoto_url(photo_eleve);
                Enseignant ens = new Enseignant();
	            	Long id_pers 		= resultat.getLong("p.id_personnel");		ens.setId(id_pers);
	            	String nom_pers 	= resultat.getString("p.nom_personnel");	ens.setNom(nom_pers);
	            	String prenom_pers  = resultat.getString("p.prenom_personnel");			ens.setPrenom(prenom_pers);
	            	String photo_pers 	= resultat.getString("p.photo_url");		ens.setPhoto_url(photo_pers);
                Salle s = new Salle();
	            	Long idSalle 		= resultat.getLong("s.id_salle");			s.setId(idSalle);
	            	String libelle_salle= resultat.getString("s.numero_salle");	s.setLibelle(libelle_salle);
	            comEE = new CommunicationEE();
	            comEE.setId_comEE(id_cee);
	            comEE.setMessage(message);
	            comEE.setDate(date);
	            comEE.setEleve(e);
	            comEE.setEnseignant(ens);
	            comEE.setSalle(s);
                
                messages.put(id_cee, comEE);
            }
            
        } catch (SQLException e) {
         	e.printStackTrace();
        } catch (Exception e) { 
         	e.printStackTrace();
        }
        finally {
        	try {
        		if (connexion != null) {	connexion.close();  	}
        	} catch (SQLException e) {
             	e.printStackTrace();
            }
        }
		return messages;
	}
	private String getInListEleve(HashMap<Long, Eleve> eleves) {
		String result = " ( ";
			
		Iterator<Map.Entry<Long, Eleve> > iterator = eleves.entrySet().iterator(); 
        while (iterator.hasNext()) { 				
        	Entry<Long, Eleve> eleve = iterator.next(); 
        	
        	result += eleve.getValue().getId_eleve().toString() + (iterator.hasNext() ? "," : "");
        } 
		
		result += ")";
		return result;
	}

}
