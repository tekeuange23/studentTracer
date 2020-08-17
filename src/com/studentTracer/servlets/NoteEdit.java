package com.studentTracer.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.studentTracer.beans.Eleve;
import com.studentTracer.beans.Enseignant;
import com.studentTracer.beans.Note;
import com.studentTracer.beans.Personnel;
import com.studentTracer.beans.Salle;
import com.studentTracer.beans.Sequence;
import com.studentTracer.dao.DaoFactory;
import com.studentTracer.dao.EleveDAO;
import com.studentTracer.dao.NoteDAO;
import com.studentTracer.dao.SalleDAO;
import com.studentTracer.dao.SequenceDAO;

@WebServlet(
        urlPatterns = "/note/edit",
        initParams = {
            @WebInitParam(name = "enseignantId", value = "1")
        }
)
public class NoteEdit extends HttpServlet {

    private EleveDAO eleveDao;
	private SalleDAO salleDAO;
	private SequenceDAO sequenceDAO;
	private NoteDAO noteDAO;
	private HashMap<Long, Salle> sallesDuProf;		//liste des salles du prof
	private HashMap<Long, Sequence> sequencesList;
	private HashMap<Long, Note> notesList;			//liste notes : id_note, note
	private ArrayList<Note> enteredNotes;			//liste de notes venant du formulaire
	private Personnel connectedEnseignant;
	private Long selectedSalleId;
	private Long selectedSequenceId;   

    public NoteEdit() {
        super();
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
		this.connectedEnseignant = new Personnel();
		this.connectedEnseignant.setId((long) 10);
		
		//2-recherche des salles du prof et Sequences
		this.sallesDuProf = this.salleDAO.getSallesByIdEnseignant(this.connectedEnseignant.getId());		
		this.notesList = null;
		this.sequencesList = this.sequenceDAO.rechercherSequences();
		
		//3-recuperation de la salle choisi  : optenu apres selection de sa salle a l'aide du ptit formulaire
		this.selectedSalleId = Long.parseLong(
				request.getParameter("salle") == null 
					? "-1"
					: request.getParameter("salle").equals("") || request.getParameter("salle").equals("-1")
						? "-1"
						: request.getParameter("salle")
		);
		//4-recuperation de la sequence choisie
		this.selectedSequenceId = Long.parseLong(
				request.getParameter("sequence") == null 
				? "-1"
				: request.getParameter("sequence").equals("") || request.getParameter("sequence").equals("-1") 
					? "-1"
					: request.getParameter("sequence")
		);
		if(request.getParameter("salle") != null && request.getParameter("sequence") != null) {
			if(!request.getParameter("salle").equals("") && !request.getParameter("sequence").equals("")) {					//salle definie
				//5-setting de la liste des NOTES
				this.notesList = this.noteDAO.getNotesList(
						connectedEnseignant, 
						this.sallesDuProf.get(this.selectedSalleId), 
						this.sequencesList.get(this.selectedSequenceId)
				);
			}
		}

		//SI: salle pas defini : alors il est obliger de choisir une salle
		request.setAttribute("selectedSalleId", this.selectedSalleId);
		request.setAttribute("salleIsSet", (this.selectedSalleId + 1) != 0);
		request.setAttribute("selectedSequenceId", this.selectedSequenceId);
		request.setAttribute("sequenceIsSet", (this.selectedSequenceId + 1) != 0);
		request.setAttribute("notesAreValid", Note.getNotesValidity());
		request.setAttribute("notesAlreadyExist", Note.getNotesExistancy());
		request.setAttribute("salles", this.sallesDuProf);
		request.setAttribute("sequences", this.sequencesList);
		request.setAttribute("notes", this.notesList);
		request.setAttribute("date_enregistrement", this.notesList == null 
				? "faux" 
				: this.notesList.size() == 0 
					? "faux" 
					:this.notesList.values().toArray(new Note[this.notesList.size()])[0].getDate_enregistrement());
		request.setAttribute("notesAreNotSet", this.notesList == null 
				? false 
				: this.notesList.size() == 0);
		request.getRequestDispatcher("/WEB-INF/note_edit.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.enteredNotes = new ArrayList<Note>();
		Note.setNotesValidityToNone();  //on initialise le boolean a chaque do post et a la construction de la servlet
		
		//6.1: recuperation dans une liste
        Iterator<Map.Entry<Long, Note> > iterator = this.notesList.entrySet().iterator(); 
        while (iterator.hasNext()) { 							//pour chaque etudiants, on prends ca Note dans le formulaire
        	Entry<Long, Note> noteI = iterator.next(); 
        	
        	Note note = Note.initNouvelleNote(request, noteI.getValue(), this.connectedEnseignant, this.sequencesList.get(selectedSequenceId));
			if(Note.getNotesValidity().equals("NO")) {
				break;									//on arrete la verification car un input est deja bad
			}
			if(!iterator.hasNext()) {	
				Note.setNotesValidityToYes();			//on a parcouru le tt le tableau ALORS les notes sont valides
			}			
			System.out.println("IDDD: " + note.getId_note());
			System.out.println("Note: " + note.getNote());
			System.out.println("Appp: " + note.getAppreciation());
			
			this.enteredNotes.add(note);
        } 
        //6.4: Enregistrement des notes dans la bd
 		if(Note.getNotesValidity().equals("YES")) {
			for(Note note: this.enteredNotes) {
				this.noteDAO.modifyNote(this.notesList.get(note.getId_note()), note);  	//ajout dans la base de donnee
				System.out.println("!!!!!!!!! SAVED !!!!!!!!" + this.notesList.get(note.getId_note()));
			}
 		}

		doGet(request, response);
	}

}
