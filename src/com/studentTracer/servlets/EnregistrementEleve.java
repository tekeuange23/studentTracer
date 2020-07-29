package com.studentTracer.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.studentTracer.beans.Eleve;
import com.studentTracer.beans.Tuteur;
import com.studentTracer.dao.ClasseDao;
import com.studentTracer.dao.DaoFactory;
import com.studentTracer.dao.EleveDAO;
import com.studentTracer.dao.TuteurDAO;
import com.studentTracer.forms.InscriptionEleveForm;

/**
 * Servlet implementation class EnregistrementEleve
 */
@WebServlet("/EnregistrementEleve")
public class EnregistrementEleve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 private EleveDAO eleveDao;
	 private ClasseDao classeDAO;
	 private TuteurDAO tuteurDAO;

	    public void init() throws ServletException {
	        DaoFactory daoFactory = DaoFactory.getInstance();
	        this.eleveDao= daoFactory.getEleveDAO();
	        this.classeDAO=daoFactory.getClasseDAO();
	        this.tuteurDAO=daoFactory.getTuteurDAO();
	    }
	    
    public EnregistrementEleve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
////		Eleve eleve=new Eleve();
////		Tuteur tuteur= new Tuteur();
////		tuteur.setNom_tuteur("mimi");
////		tuteur.setPrenom_tuteur("mpmp");
////		tuteur.setSexe('M');
////		tuteur.setEmail("mmmflflf");
////		tuteur.setNumero_telephone("4444");
////		tuteur.setLogin("ffff");
////		tuteur.setMot_de_passe("mdp");
////		int index=tuteurDAO.ajouterTuteur(tuteur);
//		System.out.println(index);
		   this.getServletContext().getRequestDispatcher("/WEB-INF/enregistrement_eleve.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Eleve eleve=new Eleve();
		Tuteur tuteur= new Tuteur();
		tuteur=tuteur.initTuteur(request);
		int index= tuteurDAO.ajouterTuteur(tuteur);
				eleve=eleve.initEleve(request, classeDAO, tuteurDAO, index);
				//System.out.println(eleve.getNom_eleve());
			eleveDao.ajouterEleve(eleve);
		}

}
