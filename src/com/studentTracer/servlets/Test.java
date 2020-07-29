package com.studentTracer.servlets;

import java.io.IOException;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentTracer.beans.Classe;
import com.studentTracer.beans.Eleve;
import com.studentTracer.beans.Tuteur;
import com.studentTracer.beans.Utilisateur;
import com.studentTracer.dao.ClasseDao;
import com.studentTracer.dao.DaoFactory;
import com.studentTracer.dao.EleveDAO;
import com.studentTracer.dao.TuteurDAO;
import com.studentTracer.dao.UtilisateurDao;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private UtilisateurDao utilisateurDao;
	 private EleveDAO eleveDao;
	 private ClasseDao classeDAO;
	 private TuteurDAO tuteurDAO;

	    public void init() throws ServletException {
	        DaoFactory daoFactory = DaoFactory.getInstance();
	        this.utilisateurDao = daoFactory.getUtilisateurDao();
	        this.eleveDao= daoFactory.getEleveDAO();
	        this.classeDAO=daoFactory.getClasseDAO();
	        this.tuteurDAO=daoFactory.getTuteurDAO();
	    }
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Date date = new Date(10,10,10);
		System.out.println("la date est :"+date.getTime());
		Classe classe=new Classe();
		classe.setId_class((long) 10);
		classe.setLibelle("maths");
		
		Tuteur tuteur =new Tuteur();
		tuteur.setNom_tuteur("doncfack");
		tuteur.setPrenom_tuteur("pierre");
		tuteur.setSexe('M');
		tuteur.setEmail("doncfack@gmail.com");
		tuteur.setNumero_telephone("6669655");
		tuteur.setLogin("donckack");
		tuteur.setMot_de_passe("doncfack");
		//tuteurDAO.ajouterTuteur(tuteur);
		
		/*Eleve eleve=new Eleve();
		eleve.setNom_eleve("toto");
		eleve.setPrenom_eleve("tata");
		eleve.setClasse(classe);
		eleve.setLogin("log");
		eleve.setMot_de_pass("motototo");
		eleve.setLieu_de_naissance("foto");
		//eleve.setDate_naissance(new Date());
		System.out.println("on ajoute");
		//eleveDAO.ajouter(new Utilisateur());*/
		//this.init();
		//Utilisateur user=new Utilisateur();
		//user.ajouterUser();
		//utilisateurDao.ajouter();
		//utilisateurDao.ajouter();
		Eleve eleve= new Eleve();
		eleve.setNom_eleve("momo");
		eleve.setPrenom_eleve("jean");
		eleve.setDate_naissance(date);
		eleve.setEmail("jean@gail.com");
		eleve.setLieu_de_naissance("dodo");
		eleve.setLogin("jean");
		eleve.setMot_de_pass("jean");
		eleve.setSexe('M');
		eleve.setTelephone("221000");
		eleve.setClasse(classeDAO.rechercherClasse(("4A")));
		//eleve.setTuteur(tuteurDAO.rechercherTuteur((long) 10, "").get(0));
		
		eleveDao.ajouterEleve(eleve);
//		ArrayList<Eleve> listeEleve=new ArrayList<Eleve>();
//		listeEleve=classeDAO.listeEleve((long) 1);
//		
//		for (Eleve eleve2 : listeEleve) {
//			System.out.println(eleve2.getId_eleve()+" "+eleve2.getNom_eleve()+" "+eleve2.getPrenom_eleve()+" "+eleve2.getSexe());
//		}
//		ArrayList<Eleve> eleves=new ArrayList<Eleve>();
//		eleves=eleveDao.rechercherEleve((long) 1, "marc");
//		for (Eleve eleve2 : eleves) {
//
//			System.out.println("Identifiant eleve: "+eleve2.getId_eleve());
//		}
		//eleveDao.supprimerEleve((long)2);
		//eleveDao.modifierElève(eleveDao.rechercherEleve((long)1, "").get(0), eleve);
		//System.out.println("libelle classe: "+classeDAO.rechercherClasse((long) 1).getLibelle());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
