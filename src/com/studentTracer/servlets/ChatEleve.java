package com.studentTracer.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentTracer.beans.CommunicationEE;
import com.studentTracer.beans.Eleve;
import com.studentTracer.beans.Enseignant;
import com.studentTracer.beans.MatiereClasse;
import com.studentTracer.beans.Salle;
import com.studentTracer.dao.CommunicationEEDAO;
import com.studentTracer.dao.DaoFactory;
import com.studentTracer.dao.EleveDAO;
import com.studentTracer.dao.SalleDAO;

@WebServlet("/chat/eleve")
public class ChatEleve extends HttpServlet {
	private EleveDAO eleveDao;
	private SalleDAO salleDAO;
	private static CommunicationEEDAO communicationEEDAO;
	
	private static HashMap<Long, MatiereClasse> matieres_salle_eleve;
	private HashMap<Long, Eleve> eleves_matiere_salle;
	private HashMap<Long, CommunicationEE> messages_matiere_salle;
	public static Eleve connectedEleve;
	
	private static Long selectedMatiereSalleId;

    public ChatEleve() {    	
        super();
    }
    public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.eleveDao = daoFactory.getEleveDAO();
		this.salleDAO = daoFactory.getSalleDAO();
		this.communicationEEDAO = daoFactory.getCommunicationEEDAO();
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//1-recherche l'eleve  par son ID
    	this.connectedEleve = new Eleve();
    	this.connectedEleve.setId_eleve((long) 4);
    	
    	//2-recherche des matieres classe  de l'eleve
    	this.matieres_salle_eleve = this.salleDAO.getMatieresSalleByIdEleve(this.connectedEleve.getId_eleve());
    	this.eleves_matiere_salle  = null;
    	    	
    	request.setAttribute("selectedSalleId", this.selectedMatiereSalleId);
		request.setAttribute("connectedEleveId", this.connectedEleve.getId_eleve());
		//request.setAttribute("matiereIsSet", (this.selectedMatiereSalleId + 1) != 0);
		request.setAttribute("matieres", this.matieres_salle_eleve);
		request.getRequestDispatcher("/WEB-INF/chatPageEleve.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
