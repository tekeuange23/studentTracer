package com.studentTracer.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentTracer.beans.Eleve;
import com.studentTracer.beans.Enseignant;
import com.studentTracer.beans.Note;
import com.studentTracer.beans.Salle;
import com.studentTracer.beans.Sequence;
import com.studentTracer.dao.DaoFactory;
import com.studentTracer.dao.EleveDAO;
import com.studentTracer.dao.NoteDAO;
import com.studentTracer.dao.SalleDAO;
import com.studentTracer.dao.SequenceDAO;

@WebServlet(
        urlPatterns = "/EnregistrementNote",
        initParams = {
            @WebInitParam(name = "enseignantId", value = "1")
        }
)
public class EnregistrementNote extends HttpServlet {
    private EleveDAO eleveDao;
	private SalleDAO salleDAO;
	private SequenceDAO sequenceDAO;
	private NoteDAO noteDAO;
	
	private HashMap<Long, Salle> sallesDuProf;		//liste des salles du prof
	private HashMap<Long, Eleve> elevesSalle;		//liste des eleves de la salle
	private HashMap<Long, Sequence> sequencesList;
	private ArrayList<Note> enteredNotes;			//liste de notes venant du formulaire
	private Enseignant connectedEnseignant;
	
	private Long selectedSalleId;
	private Long selectedSequenceId;
	private boolean notesvalides;
	
    public EnregistrementNote() {
        super();
        System.out.println( "Construction de la servlet!");
    }
	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.eleveDao = daoFactory.getEleveDAO();
		this.salleDAO = daoFactory.getSalleDAO();
		this.sequenceDAO = daoFactory.getSequenceDAO();
		this.noteDAO = daoFactory.getNoteDAO();
		this.notesvalides = true;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-recherche le prof par son ID
		this.connectedEnseignant = new Enseignant();
		this.connectedEnseignant.setId((long) 1);
		
		//2-recherche des salles du prof et Sequences
		this.sallesDuProf = this.salleDAO.rechercheSallesParIdEnseignant(this.connectedEnseignant.getId());		
		this.elevesSalle = null;
		this.sequencesList = this.sequenceDAO.rechercherSequences();
		
		//3-recuperation de la salle choisi  : optenu apres selection de sa salle a l'aide du ptit formulaire
		this.selectedSalleId = Long.parseLong(
				request.getParameter("salle") == null 
					? "-1"
					: request.getParameter("salle").equals("") || request.getParameter("salle").equals("-1")
						? "-1"
						:  request.getParameter("salle")
		);
		if(request.getParameter("salle") != null) {
			if(!request.getParameter("salle").equals("")) {					//salle definie
				//5-setting de la liste des salles du prof
				this.elevesSalle = this.salleDAO.rechercheElevesParIdSalle(this.selectedSalleId);
			}
		}
		//4-recuperation de la sequence choisie
		this.selectedSequenceId = Long.parseLong(
				request.getParameter("sequence") == null 
				? "-1"
				: request.getParameter("sequence").equals("") || request.getParameter("sequence").equals("-1") 
					? "-1"
					:  request.getParameter("sequence")
		);

		//SI: salle pas defini : alors il est obliger de choisir une salle
		request.setAttribute("selectedSalleId", this.selectedSalleId);
		request.setAttribute("salleIsSet", (this.selectedSalleId + 1) != 0);
		request.setAttribute("selectedSequenceId", this.selectedSequenceId);
		request.setAttribute("sequenceIsSet", (this.selectedSequenceId + 1) != 0);
		request.setAttribute("salles", this.sallesDuProf);
		request.setAttribute("eleves", this.elevesSalle);
		request.setAttribute("sequences", this.sequencesList);
		request.getRequestDispatcher("/WEB-INF/enregistrement _note.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println( "SalleID: " + this.selectedSalleId);
		System.out.println( "Seq__ID: " + this.selectedSequenceId);
		System.out.println( "Prof_ID: " + this.connectedEnseignant.getId());	
		
		this.enteredNotes = new ArrayList<Note>();
		//6.1: recuperation dans une liste
 		for (Map.Entry<Long, Eleve> eleve : this.elevesSalle.entrySet()) { 	//pour chaque etudiants, on prends ca Note
			Note note = Note.initNote(request, eleve.getValue(), this.connectedEnseignant, this.sequencesList.get(selectedSequenceId));
			//this.noteDAO.EnregistrerNote(note);  //ajout dans la base de donnee
			System.out.println( "\n---------------------------------------------"
							  + "\nNOTE : 		  \t\t\t" + note.getId_note()
							  + "\nAPPRECIATION : \t\t\t" + note.getAppreciation()
							  + "\nEleve :		  \t\t\t" + note.getEleve().getId_eleve()
							  + "\nProf : 		  \t\t\t" + note.getEnseignant().getId()
							  + "\nSequence : 	  \t\t\t" + note.getSequence().getId()
							  + "\n---------------------------------------------\n");
			
			this.enteredNotes.add(note);
        } 

		//6.4: Enregistrement des notes
 		if(this.notesvalides)
		for(Note note: this.enteredNotes) {
			
		}
		
		
		this.doGet(request, response);
	}
	
	public void destroy() {
        System.out.println( "Destruction de la servlet!");
	}

}
