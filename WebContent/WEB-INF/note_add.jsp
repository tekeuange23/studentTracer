<%@ page   language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 					   prefix="ng" %>
<jsp:useBean id="instanceNote" 
			 scope="page"  
			 class="com.studentTracer.beans.Note"/>

<ng:set var="salle_est_definie" value="${ salleIsSet }"></ng:set>
<ng:set var="id_salle" value="${ selectedSalleId }"></ng:set>
<ng:set var="sequence_est_definie" value="${ sequenceIsSet }"></ng:set>
<ng:set var="id_sequence" value="${ selectedSequenceId }"></ng:set>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Nouvelles Notes</title>
    <link rel="stylesheet" href="../css/note_add.css" />
    <script src="../scripts/note_add.js" defer></script>

    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta
      name="description"
      content="Responsive sidebar template with sliding effect and dropdown menu based on bootstrap 3"
    />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />
    <link
      href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      rel="stylesheet"
      id="bootstrap-css"
    />

    <link
      href="../assets/dist/css/bootstrap.css"
      rel="stylesheet"
      id="bootstrap-css"
    />
    <link
      href="../assets/dist/css/bootstrap.min.css"
      rel="stylesheet"
      id="bootstrap-css"
    />
    <link
      href="../assets/dist/css/bootstrap-reboot.css"
      rel="stylesheet"
      id="bootstrap-css"
    />
    <link
      href="https://use.fontawesome.com/releases/v5.0.6/css/all.css"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="../css/sideMenu.css" />
    <style>
      #show-sidebar {
        top: 4em;
      }
      #sidebar {
        top: 3.5em;
        bottom: 0em;
        height: auto;
      }
      .page-wrapper {
        height: auto;
      }
    </style>

    <!------------------------------------------------------------------------------------------------------------>
    <link
      rel="canonical"
      href="https://getbootstrap.com/docs/4.5/examples/offcanvas/"
    />
    <link href="../assets/dist/css/bootstrap.css" rel="stylesheet" />
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }
      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="../css/offcanvas.css" rel="stylesheet" />
    <!-----------------------------------PROPRE A LA PAGE------------------------------------------------------->
    <style>
      .mb-3 > label {
        font-weight: bold;
      }
      .entete .col-md-1.order-md-1 > p {
        margin: 0px;
        padding: 0px;
        font-weight: bold;
      }
      .entete .col-md-4.order-md-1 {
        align-items: center;
        justify-content: center;
        text-transform: uppercase;
        font-weight: bold;
        size: 2rem;
      }
    </style>
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta
      name="author"
      content="Mark Otto, Jacob Thornton, and Bootstrap contributors"
    />
    <meta name="generator" content="Jekyll v4.0.1" />

    <link href="../css/floating-labels-tuteur.css" rel="stylesheet" />
    <link
      rel="canonical"
      href="https://getbootstrap.com/docs/4.5/examples/checkout/"
    />

    <!-- Bootstrap core CSS -->
    <link href="../assets/dist/css/bootstrap.css" rel="stylesheet" />

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="../css/enregistrement_personnel.css" rel="stylesheet" />
    <link href="../css/enregistrement_eleve.css" rel="stylesheet" />

    <!--<script src="../scripts/enregistrer_eleve.js" defer></script>-->
    <script src="../scripts/sideMenu.js" defer></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
  </head>

  <body>
    <div class="page-wrapper chiller-theme toggled">
      <!-- ****************************************** SIDE MENU *********************************************** -->
      <a id="show-sidebar" class="btn btn-sm btn-dark" href="#">
        <i class="fas fa-bars"></i>
      </a>
      <nav id="sidebar" class="sidebar-wrapper">
        <div class="sidebar-content">
          <div class="sidebar-brand">
            <a href="#">pro sidebar</a>
            <div id="close-sidebar">
              <i class="fas fa-times"></i>
            </div>
          </div>
          <div class="sidebar-header">
            <div class="user-pic">
              <img
                class="img-responsive img-rounded"
                src="https://raw.githubusercontent.com/azouaoui-med/pro-sidebar-template/gh-pages/src/img/user.jpg"
                alt="User picture"
              />
            </div>
            <div class="user-info">
              <span class="user-name"
                >Ange
                <strong>Tekeu</strong>
              </span>
              <span class="user-role">Enseignant</span>
              <span class="user-status">
                <i class="fa fa-circle"></i>
                <span>Online</span>
              </span>
            </div>
          </div>
          <!-- sidebar-header  -->
          <div class="sidebar-search">
            <div>
              <div class="input-group">
                <input
                  type="text"
                  class="form-control search-menu"
                  placeholder="Search..."
                />
                <div class="input-group-append">
                  <span class="input-group-text">
                    <i class="fa fa-search" aria-hidden="true"></i>
                  </span>
                </div>
              </div>
            </div>
          </div>

          <!-- sidebar-menu  -->
        </div>
        <!-- sidebar-content  -->
        <div class="sidebar-footer">
          <a href="#">
            <i class="fa fa-bell"></i>
            <span class="badge badge-pill badge-warning notification">3</span>
          </a>
          <a href="#">
            <i class="fa fa-envelope"></i>
            <span class="badge badge-pill badge-success notification">7</span>
          </a>
          <a href="#">
            <i class="fa fa-cog"></i>
            <span class="badge-sonar"></span>
          </a>
          <a href="#">
            <i class="fa fa-power-off"></i>
          </a>
        </div>
      </nav>
      <!-- ****************************************** TOP MENU ************************************************ -->
      <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
        <a class="navbar-brand mr-auto mr-lg-0" href="#">Student Tracer</a>
        <button
          class="navbar-toggler p-0 border-0"
          type="button"
          data-toggle="offcanvas"
        >
          <span class="navbar-toggler-icon"></span>
        </button>

        <div
          class="navbar-collapse offcanvas-collapse"
          id="navbarsExampleDefault"
        >
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#"
                >Dashboard <span class="sr-only">(current)</span></a
              >
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Notifications</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Profile</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Switch account</a>
            </li>
            <li class="nav-item dropdown">
              <a
                class="nav-link dropdown-toggle"
                href="#"
                id="dropdown01"
                data-toggle="dropdown"
                aria-haspopup="true"
                aria-expanded="false"
                >Settings</a
              >
              <div class="dropdown-menu" aria-labelledby="dropdown01">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <a class="dropdown-item" href="#">Something else here</a>
              </div>
            </li>
          </ul>
          <form class="form-inline my-2 my-lg-0">
            <input
              class="form-control mr-sm-2"
              type="text"
              placeholder="Search"
              aria-label="Search"
            />
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
              Search
            </button>
          </form>
        </div>
      </nav>

      <!-- ****************************************** CONTENT  ************************************************ -->
      <main class="page-content">
        <div class="py-5 text-center">
          <img
            class="d-block mx-auto mb-4"
            src="../assets/brand/bootstrap-solid.svg"
            alt=""
            width="72"
            height="72"
          />
          
          <h2>Enregistrer vos notes</h2>
        </div>
		
		<!-- BODY -->
        <div class="row">
          <!--Formulaire1-->
          <form method="GET" 
          		action="ajout" 
          		class="needs-validation w-100" 
          		style="margin-bottom: 5rem;">
          	<div class="row border-bottom border-dark">
	            <!--Sequence-->
	            <div class="row w-100">
	              <div class="col-md-12 order-md-1">
	                <div class="row">
	                  <h3 class="col-md-9 mb-3">
	                    Sequence:
	                  </h3>
	                  <div class="col-md-3 mb-3">
		                    <div class="input-group">
		                      <select
		                      	onchange="this.form.submit()"
		                        id="sequence"
		                        name="sequence"
		                        class="custom-select d-block w-100"
		                        require
		                      >
								<option value="-1">sequence...</option>
		                        <ng:forEach items="${ sequences }" var="seq">
			                        <option class="seq-options" 
			                        		name="${seq.key}" 
			                        		value="${seq.key}"
			                        		${seq.key == selectedSequenceId ? 'selected' : ''}>
			                        		${ seq.value.libelle }</option>
			                    </ng:forEach>
		                      </select>
		                    </div>
	                  </div>
	                </div>
	              </div>
	            </div>
	            
	            <!--Salle-->
	            <div class="row w-100">
	              <div class="col-md-12 order-md-1">
	                <div class="row">
	                  <h3 class="col-md-9 mb-3" for="date_fiche">
	                    Salle:
	                  </h3>
	                  <div class="col-md-3 mb-3">
		                    <div class="form-label-group">
		                      <select 
		                        class="custom-select d-block w-100"
		                      	onchange="this.form.submit()"
		                        id="salle"
		                        name="salle"
		                        require
		                      >
		                       <option value="-1">salle...</option>
		                        <ng:forEach items="${ salles }" var="salle">
		                        	<option class="salle-options" 
		                        			name="${salle.key}" 
		                        			value="${salle.key}"
			                        		${salle.key == selectedSalleId ? 'selected' : ''}>
		                        			${ salle.value.classe.libelle }-${salle.value.libelle}</option>
		                        </ng:forEach>
		                      </select>
		                    </div>
	                  </div>
	                </div>
	              </div>
	            </div>
          	</div>
          </form>
			
		  <!--Formulaire2-->
          <form	method="POST"
            action="ajout?sequence=${ selectedSequenceId }&salle=${ selectedSalleId }"
            id="needs-validation"
            class="needs-validation w-100"
            novalidate
          >
          	<div class="row">
	            <ng:choose>
				  <ng:when test="${ salle_est_definie == false || sequence_est_definie == false }">
				    <div class="row w-100 text-center bg-dark rounded">
				    	<h1 class="w-100 text-danger mt-3">SELECTIONNER UNE SALLE ET UNE SEQUENCE</h1>
				    </div>
				  </ng:when>
				  <ng:when test="${ salle_est_definie == true  && sequence_est_definie == true  }">
				  	<!--Entete-->
		            <div class="row w-100 mb-2">
		              <div class="col-md-4 order-md-1 font-weight-bold .small">NOMS ET PRENOMS</div>
		              <div class="col-md-4 order-md-1 font-weight-bold">NOTES</div>
		              <div class="col-md-4 order-md-1 font-weight-bold">APPRECIATIONS</div>
		            </div>
		            
	            	<!--Liste des eleve-->
				  	<div class="row w-100 .text-left">
				  	<ng:forEach items="${ eleves }" var="eleve">
			            <div class="col-md-12 w-100 mb-1">
			               <div class="row w-100 justify-content-start ">
			                  <div class="col-md-4 order-md-1 align-bottom text-uppercase">
			                  		${ eleve.value.nom_eleve }  ${ eleve.value.prenom_eleve }</div>
			                  <div class="col-md-4 order-md-1" id="champ-note">
			                    <input
			                      type="text"
			                      min="0"
			                      max="20"
			                      class="form-control"
			                      id="note"
			                      placeholder="Note"
			                      name="note-${eleve.key}"
			                      required
			                    />
			                  </div>
			                  <div class="col-md-4 order-md-1" id="champ-appreciation">
			                    <input
			                      type="text"
			                      class="form-control"
			                      id="appreciation"
			                      placeholder="Appreciation"
			                      name="appreciation-${eleve.key}"
			                      required
			                    />
			                  </div>
			                </div>
			              </div>
		              </ng:forEach>
	            	</div>
	            	
	            	<!--Button Start MODAL-->
		            <div class="row" style="width: 100%; margin-top: 3rem;">
		              <hr class="mb-4" />
		              <button
		                id="startModal"
		                type="button"
		                class="btn btn-primary btn-lg btn-block"
		                data-toggle="modal" 
		                data-target="#myModal">
		                  Enregistrer les notes
		              </button>
		            </div>
      				<!-- ******************************************  MODAL 1 ******************************************* -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					  <div class="modal-dialog modal-dialog-centered" role="document">
					    <div class="modal-content" style="background: #31353D;">
					      <div class="modal-header">
					        <h5 class="modal-title text-white" id="exampleModalLongTitle">Confirmation</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body font-weight-bold text-center text-white">
							Vous etes sur le point d'enregistrer les notes
							<ng:out value="de la ${sequences[id_salle].libelle}"/>
				          	<ng:out value="en ${salles[id_salle].classe.libelle}-${salles[id_salle].libelle}"/>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-danger" data-dismiss="modal">Annuler</button>
					        <button type="submit" id="submitBtn" class="btn btn-primary">Confirmer</button>
					      </div>
					    </div>
					  </div>
					</div>
				  </ng:when>
				</ng:choose>
             </div>
          </form>
        </div>

        <script>
          window.jQuery ||
            document.write(
              '<script src="../assets/jquery-3.5.1.slim.min.js"><\/script>'
            );
        </script>
        <script src="../assets/dist/js/bootstrap.bundle.js"></script>
        <script src="../scripts/offcanvas.js"></script>
      </main>
    
      <!-- ****************************************** ERROR MODAL 1 ******************************************* -->
	  <div class="modal fade" 
	  	   id="errorModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		      	<ng:if test="${ notesAreValid == 'YES' }">
		        	<h5 class="modal-title" id="exampleModalLabel text-success">NOTES ENREGISTREES</h5>
				</ng:if>
				<ng:if test="${ notesAreValid == 'NO' }">
		        	<h5 class="modal-title" id="exampleModalLabel text-warning">NOTES NON ENREGISTREES</h5>
				</ng:if>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body text-info">
				  <ng:if test="${ notesAreValid == 'YES' }">
				  	<div class="font-weight-bold text-center text-success">
				  		Les notes ont ete enregistrees avec succes.
				  	</div>
				  </ng:if>
				  <ng:if test="${ notesAreValid == 'NO' }">
				  	<div class="font-weight-bold text-center text-danger">
				  		Verifier que les notes sont bien des entiers compris entre 0 et 20.
				  	</div>
				  </ng:if>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Compris</button>
		      </div>
		    </div>
		  </div>
	  </div>
      <ng:if test="${ (notesAlreadyExist != 'YES') && (notesAreValid == 'YES' || notesAreValid == 'NO') }">
	  	<script>
	  		$('#errorModal').modal('show'); 
	  	</script>
	  	<!--  EXECUTER UN CODE JAVA POUR SET A 'NONE' apres l'execution du javascript -->
	  	<%	
	  		instanceNote.setNotesValidityToNone();	
	  		instanceNote.setNotesExistancyToNone();
	  	%>
	  </ng:if>
      <!-- ****************************************** EXISTANCE MODAL 1 *************************************** -->
	  <div class="modal fade" 
	  	   id="existanceModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
				<ng:if test="${ notesAlreadyExist == 'YES' }">
		        	<h5 class="modal-title" id="exampleModalLabel text-primary">NOTES NON ENREGISTREES</h5>
				</ng:if>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body text-info">
				  <ng:if test="${ notesAlreadyExist == 'YES' }">
				  	<div class="font-weight-bold text-center text-warning">
				  		Cette operation a deja ete effectuee.
				  	</div>
				  </ng:if>
		      </div>
		      <div class="modal-footer">
				 <a href="edit?sequence=${ selectedSequenceId }&salle=${ selectedSalleId }"
				    class="btn btn-success" role="button" aria-controls="collapseExample">Editer</a>
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Compris</button>
		      </div>
		    </div>
		  </div>
	  </div>
	  <ng:if test="${ notesAlreadyExist == 'YES' }">
	  	<script>
	  		$('#existanceModal').modal('show'); 
	  	</script>
	  	<!--  EXECUTER UN CODE JAVA POUR SET A 'NONE' apres l'execution du javascript -->
	  	<%	
	  		instanceNote.setNotesValidityToNone();	
  			instanceNote.setNotesExistancyToNone();
	  	%>
	  </ng:if>
	  
    </div>
    <!-- page-wrapper -->
    <!--
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
      integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
      integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
      crossorigin="anonymous"
    ></script>
    -->
    <script src="../assets/jquery-3.5.1.slim.min.js"></script>

    <script src="../assets/dist/js/bootstrap.min.js"></script>
    <script src="../assets/jquery-3.5.1.min.js"></script>

    <!--PROPRE A LA PAGE-->
    <script
      src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
      integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
      crossorigin="anonymous"
    ></script>
    <script>
      window.jQuery ||
        document.write(
          '<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>'
        );
    </script>
    <script src="../assets/dist/js/bootstrap.bundle.js"></script>
    <script src="../scripts/enregistrement_personnel.js"></script>
  </body>
</html>
