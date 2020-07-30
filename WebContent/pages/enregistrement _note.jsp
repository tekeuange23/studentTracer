<@% page   language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<@% taglib uri="http://java.sun.com/jsp/jstl/core" 					   prefix="ng" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Nouvelles Notes</title>
    <link rel="stylesheet" href="../css/enregistrement_note.css" />

    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta
      name="description"
      content="Responsive sidebar template with sliding effect and dropdown menu based on bootstrap 3"
    />
    <title>Nouvelle</title>
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
    <link href="./assets/dist/css/bootstrap.css" rel="stylesheet" />
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
      <!-- ****************************************** SIDE MENU ************************************************ -->
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
                >Jhon
                <strong>Smith</strong>
              </span>
              <span class="user-role">Administrator</span>
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
          <!-- sidebar-search  -->
          <div class="sidebar-menu">
            <ul>
              <li class="header-menu">
                <span>General</span>
              </li>
              <li class="sidebar-dropdown">
                <a href="#">
                  <i class="fa fa-tachometer-alt"></i>
                  <span>Dashboard</span>
                  <span class="badge badge-pill badge-warning">New</span>
                </a>
                <div class="sidebar-submenu">
                  <ul>
                    <li>
                      <a href="#"
                        >Dashboard 1
                        <span class="badge badge-pill badge-success">Pro</span>
                      </a>
                    </li>
                    <li>
                      <a href="#">Dashboard 2</a>
                    </li>
                    <li>
                      <a href="#">Dashboard 3</a>
                    </li>
                  </ul>
                </div>
              </li>
              <li class="sidebar-dropdown">
                <a href="#">
                  <i class="fa fa-shopping-cart"></i>
                  <span>E-commerce</span>
                  <span class="badge badge-pill badge-danger">3</span>
                </a>
                <div class="sidebar-submenu">
                  <ul>
                    <li>
                      <a href="#">Products </a>
                    </li>
                    <li>
                      <a href="#">Orders</a>
                    </li>
                    <li>
                      <a href="#">Credit cart</a>
                    </li>
                  </ul>
                </div>
              </li>
              <li class="sidebar-dropdown">
                <a href="#">
                  <i class="far fa-gem"></i>
                  <span>Components</span>
                </a>
                <div class="sidebar-submenu">
                  <ul>
                    <li>
                      <a href="#">General</a>
                    </li>
                    <li>
                      <a href="#">Panels</a>
                    </li>
                    <li>
                      <a href="#">Tables</a>
                    </li>
                    <li>
                      <a href="#">Icons</a>
                    </li>
                    <li>
                      <a href="#">Forms</a>
                    </li>
                  </ul>
                </div>
              </li>
              <li class="sidebar-dropdown">
                <a href="#">
                  <i class="fa fa-chart-line"></i>
                  <span>Charts</span>
                </a>
                <div class="sidebar-submenu">
                  <ul>
                    <li>
                      <a href="#">Pie chart</a>
                    </li>
                    <li>
                      <a href="#">Line chart</a>
                    </li>
                    <li>
                      <a href="#">Bar chart</a>
                    </li>
                    <li>
                      <a href="#">Histogram</a>
                    </li>
                  </ul>
                </div>
              </li>
              <li class="sidebar-dropdown">
                <a href="#">
                  <i class="fa fa-globe"></i>
                  <span>Maps</span>
                </a>
                <div class="sidebar-submenu">
                  <ul>
                    <li>
                      <a href="#">Google maps</a>
                    </li>
                    <li>
                      <a href="#">Open street map</a>
                    </li>
                  </ul>
                </div>
              </li>
              <li class="header-menu">
                <span>Extra</span>
              </li>
              <li>
                <a href="#">
                  <i class="fa fa-book"></i>
                  <span>Documentation</span>
                  <span class="badge badge-pill badge-primary">Beta</span>
                </a>
              </li>
              <li>
                <a href="#">
                  <i class="fa fa-calendar"></i>
                  <span>Calendar</span>
                </a>
              </li>
              <li>
                <a href="#">
                  <i class="fa fa-folder"></i>
                  <span>Examples</span>
                </a>
              </li>
            </ul>
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
        <a class="navbar-brand mr-auto mr-lg-0" href="#">Offcanvas navbar</a>
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
          <h2>Nouveau Eleve</h2>
        </div>

        <div class="row">
          <form
            method="POST"
            class="needs-validation"
            novalidate
            style="width: 100%;"
          >
            <!--Sequence-->
            <div class="row sequence">
              <div class="col-md-12 order-md-1">
                <div class="row">
                  <h3 class="col-md-9 mb-3" for="date_fiche">
                    Sequence:
                  </h3>
                  <div class="col-md-3 mb-3">
                    <div class="input-group">
                      <select
                        id="sequence"
                        name="sequence"
                        class="custom-select d-block w-100"
                      >
                        <option value="">sequence...</option>
                        <option value="1">first</option>
                        <option value="2">second</option>
                        <option value="3">Third</option>
                        <option value="4">Fourth</option>
                        <option value="5">Fifth</option>
                        <option value="6">Sixth</option>
                      </select>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!--Salle-->
            <div class="row salle">
              <div class="col-md-12 order-md-1">
                <div class="row">
                  <h3 class="col-md-9 mb-3" for="date_fiche">
                    Salle:
                  </h3>
                  <div class="col-md-3 mb-3">
                    <div class="form-label-group">
                      <select
                        id="salle"
                        name="salle"
                        class="custom-select d-block w-100"
                      >
                        <option value="">salle...</option>
                        <option value="6eM1">6eM1</option>
                        <option value="6eM2">6eM2</option>
                      </select>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <br />

            <!--Corp-->
            <div class="row entete">
              <div class="col-md-4 order-md-1">NOMS ET PRENOMS</div>
              <div class="col-md-4 order-md-1">NOTES</div>
              <div class="col-md-4 order-md-1">APPRECIATIONS</div>
            </div>

            <div class="row list">
              <div class="col-md-12">
                <div class="row item">
                  <div class="col-md-4 order-md-1">TENE TEKEU ANGE LEONEL</div>
                  <div class="col-md-4 order-md-1">
                    <input
                      type="text"
                      class="form-control"
                      id="note"
                      placeholder="Note"
                      value=""
                      name="note"
                      required
                    />
                  </div>

                  <div class="col-md-4 order-md-1">
                    <input
                      type="text"
                      class="form-control"
                      id="appreciation"
                      placeholder="Appreciation"
                      value=""
                      name="appreciation"
                      required
                    />
                  </div>
                </div>
              </div>
            </div>

            <!--Button Start MODAL-->
            <div class="row" style="width: 100%; margin-top: 3rem;">
              <hr class="mb-4" />
              <button
                id="startModal"
                type="submit"
                href="#"
                class="btn btn-primary btn-lg btn-block"
              >
                Enregistrer nouveau note
              </button>
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
      <!-- page-content" -->
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
