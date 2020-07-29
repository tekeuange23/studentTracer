package com.studentTracer.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentTracer.dao.AbscenceDAO;
import com.studentTracer.dao.ClasseDao;
import com.studentTracer.dao.CreneauHoraireDAO;
import com.studentTracer.dao.DaoFactory;
import com.studentTracer.dao.EleveDAO;
import com.studentTracer.dao.TuteurDAO;

/**
 * Servlet implementation class Abscence
 */
@WebServlet("/Abscence")
public class EnregistrementAbscence extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrementAbscence() {
        super();
        // TODO Auto-generated constructor stub
    }

	 private EleveDAO eleveDao;
	 private AbscenceDAO abscenceDAO;
	 private CreneauHoraireDAO creneauDAO;
	 
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.eleveDao= daoFactory.getEleveDAO();
        this.abscenceDAO=daoFactory.getAbscenseDAO();
        this.creneauDAO=daoFactory.getCreneauHoraireDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
