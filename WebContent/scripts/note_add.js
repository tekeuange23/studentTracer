$("#submitBtn").click(function () {
    $('#myModal').modal('hide');
	$('body').removeClass('modal-open');
	$('.modal-backdrop').remove();
}); 



//			System.out.println( "\n---------------------------------------------"
//							  + "\nNOTE : 		  \t\t\t" + note.getId_note()
//							  + "\nAPPRECIATION:\t\t\t\t" + note.getAppreciation()
//							  + "\nEleve :		  \t\t\t" + note.getEleve().getId_eleve()
//							  + "\nProf : 		  \t\t\t" + note.getEnseignant().getId()
//							  + "\nSequence : 	  \t\t\t" + note.getSequence().getId()
//							  + "\nValidity : 	  \t\t\t" + Note.getNotesValidity()
//							  + "\n---------------------------------------------\n");