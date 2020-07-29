package com.studentTracer.forms;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.studentTracer.beans.Eleve;
import com.studentTracer.dao.ClasseDao;
import com.studentTracer.dao.TuteurDAO;

public class InscriptionEleveForm {

	private static final String CHAMP_NOM="nom_eleve";
	private static final String CHAMP_PRENOM="prenom_eleve";
	private static final String CHAMP_SEXE="sexe";
	private static final String CHAMP_DATENAISS="date_naissance";
	private static final String CHAMP_LIEUNAIS="lieu_naissance";
	private static final String CHAMP_EMAIL="email_eleve";
	private static final String CHAMP_TEL="telephone";
	private static final String CHAMP_MDP="password";
	private static final String CHAMP_LOGIN="login";
	private static final String CHAMP_LIBCLASS="libelle_classe";
	private String resultat;
    private Map<String, String> erreurs= new HashMap<String, String>();
    
    
	public Eleve initEleve(HttpServletRequest request, ClasseDao classeDAO , TuteurDAO tuteurDAO, int id_tuteur) {
		 Eleve eleve=new Eleve();
		 String nom=getValeur(request, CHAMP_NOM);
		 String prenom=getValeur(request, CHAMP_PRENOM);
		 char sexe;
		 Date date_naissance=null;
		 
		 
		 	if(getValeur(request, CHAMP_SEXE)!=null) {
		 		try {
		 		 sexe=getValeur(request, CHAMP_SEXE).charAt(0);
		 		} catch (Exception e) {
					// TODO: handle exception

	        		System.out.println("InscriptionEleveForm:: "+e.getMessage());
				}
		 	}
		 	
		 	if(getValeur(request, CHAMP_DATENAISS)!=null) {
		 		try {
		 		 date_naissance=Date.valueOf(getValeur(request, CHAMP_DATENAISS));
		 		} catch (Exception e) {
					// TODO: handle exception

	        		System.out.println("InscriptionEleveForm/Date:: "+e.getMessage());
				}
		 	}
		 	
		 	
		 String lieu_naiss=getValeur(request, CHAMP_LIEUNAIS);
		 String email=getValeur(request, CHAMP_EMAIL);
		 String tel=getValeur(request, CHAMP_TEL);
		 String mdp=getValeur(request, CHAMP_MDP);
		 String login=getValeur(request, CHAMP_LOGIN);
		 String libclass=getValeur(request, CHAMP_LIBCLASS);
		 
		 try {
			validationNom(nom);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 eleve.setNom_eleve(request.getParameter("nom_eleve"));
		 eleve.setPrenom_eleve(request.getParameter("prenom_eleve"));
		 eleve.setSexe(request.getParameter("sexe").charAt(0));
		 eleve.setDate_naissance(Date.valueOf((request.getParameter("date_naissance"))));
		 eleve.setLieu_de_naissance(request.getParameter("lieu_naissance"));
		 eleve.setEmail(request.getParameter("email_eleve"));
		 eleve.setTelephone(request.getParameter("telephone"));
		 eleve.setMot_de_pass("password");
		 eleve.setLogin("login");
		eleve.setClasse(classeDAO.rechercherClasse(request.getParameter("libelle_classe")));

		 eleve.setTuteur(tuteurDAO.rechercherTuteur((long)id_tuteur).get(0));
		 
		 System.out.println("innitialisation eleve terminé");
		 
		return eleve;
	 }
	
	
	
	
	public String getValeur(HttpServletRequest request,String cle) {
		String valeur=request.getParameter(cle);
		
		if(valeur==null || valeur.trim().length()==0) {
			return null;
		}else {
		return valeur;}
	}
	

    private void validationNom( String nom ) throws Exception {
    	if ( nom != null ) {
		
    		if ( nom.length()<2 && nom.length()>30){
    			throw new Exception( "votre nom doit contenir au moins 3 caractares et au plus 30 caractéres" );
        	}	
		}else {

            throw new Exception( "Merci d'entrer votre nom " );
		}
    }
    private void validationPrenom( String prenom ) throws Exception {
    	if ( prenom != null ) {
		
    		if (prenom.trim().length()<2 && prenom.trim().length()>30){
    			throw new Exception( "votre prenom doit contenir au moins 4 caract�res." );
        	}	
		}else {

            throw new Exception( "Merci d'entrer votre prenom " );
		}
    }
    private void validationSexe( String sexe ) throws Exception {
    	if ( sexe != null ) {
		
    		if ( sexe.trim().length()!=0 ){
    			throw new Exception( "votre sexe doit contenir 1 caract�res." );
        	}	
		}else {

            throw new Exception( "Merci de selectionner votre sexe " );
		}
    }
    private void validationDateNaiss( String dateNaiss ) throws Exception {
    	if ( dateNaiss != null ) {
		
//    		if ( dateNaiss.length()<4 ){
//    			throw new Exception( "l doit contenir au moins 4 caract�res." );
//        	}	
		}else {

            throw new Exception( "Merci d'entrer votre nom d'utilisateur " );
		}
    }
    
    
    private void validationLieuNaiss( String lieuNaiss ) throws Exception {
    	if ( lieuNaiss != null ) {
		
//    		if ( dateNaiss.length()<4 ){
//    			throw new Exception( "l doit contenir au moins 4 caract�res." );
//        	}	
		}else {

            throw new Exception( "Merci d'entrer votre nom d'utilisateur " );
		}
    }

    private void validationLEma( String lieuNaiss ) throws Exception {
    	if ( lieuNaiss != null ) {
		
//    		if ( dateNaiss.length()<4 ){
//    			throw new Exception( "l doit contenir au moins 4 caract�res." );
//        	}	
		}else {

            throw new Exception( "Merci d'entrer votre nom d'utilisateur " );
		}
    }
    
    
    
    
    private void validationMdp( String mdp ) throws Exception {
    	if ( mdp != null ) {
		
    		if ( mdp.length()<4 ){
    			throw new Exception( "votre mot de passe doit contenir au moins 4 caract�res." );
        	}	
		}else {

            throw new Exception( "Merci d'entrer votre mot de passe " );
		}
    }
    private void validationTel( Long tel ) throws Exception {
    	if ( tel != null ) {
		
    		if ( tel.toString().length()<6 ){
    			throw new Exception( "votre telephone doit contenir au moins 6 caract�res." );
        	}	
		}else {

            throw new Exception( "Merci d'entrer votre telephone " );
		}
    }
    private void setErreur( String champ, String message ) {
    	System.out.println("erreur detecter::"+message);
        erreurs.put( champ, message );
    }
}
