package com.studentTracer.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

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
        urlPatterns = "/note/ajout",
        initParams = {
            @WebInitParam(name = "enseignantId", value = "1")
        }
)
public class NoteAdd extends HttpServlet {
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
	
    public NoteAdd() {
        super();
        System.out.println( "Construction de la servlet!");
    }
	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.eleveDao = daoFactory.getEleveDAO();
		this.salleDAO = daoFactory.getSalleDAO();
		this.sequenceDAO = daoFactory.getSequenceDAO();
		this.noteDAO = daoFactory.getNoteDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-recherche le prof par son ID
		this.connectedEnseignant = new Enseignant();
		this.connectedEnseignant.setId((long) 10);
		
		//2-recherche des salles du prof et Sequences
		this.sallesDuProf = this.salleDAO.getSallesByIdEnseignant(this.connectedEnseignant.getId());		
		this.elevesSalle  = null;
		this.sequencesList= this.sequenceDAO.rechercherSequences();
		
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
				this.elevesSalle = this.salleDAO.getSalleByIdSalle(this.selectedSalleId);
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
		request.setAttribute("notesAreValid", Note.getNotesValidity());
		request.setAttribute("notesAlreadyExist", Note.getNotesExistancy());
		request.setAttribute("salles", this.sallesDuProf);
		request.setAttribute("eleves", this.elevesSalle);
		request.setAttribute("sequences", this.sequencesList);
		request.getRequestDispatcher("/WEB-INF/note_add.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println( "SalleID: " + this.selectedSalleId);
//		System.out.println( "Seq__ID: " + this.selectedSequenceId);
//		System.out.println( "Prof_ID: " + this.connectedEnseignant.getId());	
		
		this.enteredNotes = new ArrayList<Note>();
		Note.setNotesValidityToNone();  //on initialise le boolean a chaque do post et a la construction de la servlet
		Note.setNotesExistancyToNone();
		
		//6.1: recuperation dans une liste
        Iterator<Map.Entry<Long, Eleve> > iterator = this.elevesSalle.entrySet().iterator(); 
        while (iterator.hasNext()) { 							//pour chaque etudiants, on prends ca Note dans le formulaire
        	Entry<Long, Eleve> eleve = iterator.next(); 
        	
        	Note note = Note.initNote(request, eleve.getValue(), this.connectedEnseignant, this.sequencesList.get(selectedSequenceId));
			if(Note.getNotesValidity().equals("NO")) {
				break;									//on arrete la verification car un input est deja bad
			}
			if(!iterator.hasNext()) {	
				Note.setNotesValidityToYes();			//on a parcouru le tt le tableau ALORS les notes sont valides
			}			
			
			this.enteredNotes.add(note);
        } 
        //6.4: Enregistrement des notes dans la bd
 		if(Note.getNotesValidity().equals("YES")) {
			System.out.println("!!!!!!!!! SAVED !!!!!!!!");
			for(Note note: this.enteredNotes) {
				this.noteDAO.addNote(note);  			//ajout dans la base de donnee
				if(Note.getNotesExistancy().equals("YES")) {	//si la premiere note existe deja j'arrete l'ajout
					break;
				}
			}
 		}
		

		System.out.println("NOTE.Exist : " + Note.getNotesExistancy());
		System.out.println("NOTE.Valid : " + Note.getNotesValidity());
		this.doGet(request, response);
	}
	
	public void destroy() {
        System.out.println( "Destruction de la servlet!");
	}
}
