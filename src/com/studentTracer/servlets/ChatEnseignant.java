package com.studentTracer.servlets;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentTracer.beans.CommunicationEE;
import com.studentTracer.beans.Eleve;
import com.studentTracer.beans.Enseignant;
import com.studentTracer.beans.Note;
import com.studentTracer.beans.Salle;
import com.studentTracer.dao.CommunicationEEDAO;
import com.studentTracer.dao.DaoFactory;
import com.studentTracer.dao.EleveDAO;
import com.studentTracer.dao.SalleDAO;


@WebServlet("/chat/enseignant")
public class ChatEnseignant extends HttpServlet {
	private EleveDAO eleveDao;
	private SalleDAO salleDAO;
	private static CommunicationEEDAO communicationEEDAO;
	
	private static HashMap<Long, Salle> sallesDuProf;
	private HashMap<Long, Eleve> elevesSalle;
	private HashMap<Long, CommunicationEE> messagesSalles;
	public static Enseignant connectedEnseignant;
	
	private static Long selectedSalleId;
	
    public ChatEnseignant() {
        super();
    }public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.eleveDao = daoFactory.getEleveDAO();
		this.salleDAO = daoFactory.getSalleDAO();
		this.communicationEEDAO = daoFactory.getCommunicationEEDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-recherche le prof par son ID
		this.connectedEnseignant = new Enseignant();
		this.connectedEnseignant.setId((long) 10);
		
		//2-recherche des salles du prof
		this.sallesDuProf = this.salleDAO.getSallesByIdEnseignant(this.connectedEnseignant.getId());		
		this.elevesSalle  = null;
		
		//3-recuperation de la salle choisi  : optenu apres selection de sa salle a l'aide du ptit formulaire
		Entry<Long, Salle> entry = this.sallesDuProf.entrySet().iterator().next();
		Salle firstSalle = entry.getValue();
		this.selectedSalleId = Long.parseLong(
				request.getParameter("salle") == null 
					? this.sallesDuProf == null
						? "-1"
						: firstSalle.getId().toString()
					: request.getParameter("salle").equals("") || request.getParameter("salle").equals("-1")
						? firstSalle.getId().toString()
						:  request.getParameter("salle")
		);
		if(request.getParameter("salle") != null) {
			if(!request.getParameter("salle").equals("")) {					//salle definie
				//5-setting de la liste des salles du prof
				this.elevesSalle = this.salleDAO.getSalleByIdSalle(this.selectedSalleId);
				this.messagesSalles = this.communicationEEDAO.getAllMessages(this.connectedEnseignant, this.elevesSalle, this.sallesDuProf.get(selectedSalleId));
			}
		}
		
		ArrayList<CommunicationEE> orderedMessages = new ArrayList<CommunicationEE>(
				this.messagesSalles != null 
					? this.messagesSalles.values()
					: new HashMap<Long, CommunicationEE>().values()
		);
		orderedMessages.sort(Comparator.comparing(CommunicationEE::getId_comEE));
		//Collections.sort(orderedMessages, Comparator.comparing(CommunicationEE::getId_comEE));
		
		request.setAttribute("selectedSalleId", this.selectedSalleId);
		request.setAttribute("connectedProfId", this.connectedEnseignant.getId());
		request.setAttribute("salleIsSet", (this.selectedSalleId + 1) != 0);
		request.setAttribute("salles", this.sallesDuProf);
		request.setAttribute("eleves", this.elevesSalle);
		request.setAttribute("messages", this.messagesSalles);
		request.setAttribute("orderedMessages", orderedMessages);
		request.getRequestDispatcher("/WEB-INF/chatPageEnseignant.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	public static Enseignant getConnectedEnseignant() {
		return connectedEnseignant;
	}
	public static Salle getSelectedSalle() {
		return sallesDuProf.get(selectedSalleId);
	}
	public static CommunicationEEDAO getCommunicationEEDAO(){
		return communicationEEDAO;
	}
	
	
}
