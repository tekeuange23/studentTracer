package com.studentTracer.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.studentTracer.daoImplements.AbscenseDAOImpl;
import com.studentTracer.daoImplements.ClasseDAOImpl;
import com.studentTracer.daoImplements.CommunicationEEDAOImpl;
import com.studentTracer.daoImplements.CreneauDAOImpl;
import com.studentTracer.daoImplements.EleveDAOImpl;
import com.studentTracer.daoImplements.NoteDAOImpl;
import com.studentTracer.daoImplements.SalleDAOImpl;
import com.studentTracer.daoImplements.SequenceDAOImpl;
import com.studentTracer.daoImplements.TuteurDAOImpl;

public class DaoFactory {
    private String url;
    private String username;
    private String password;

    private DaoConnParams connParams = new DaoConnParams();
    public DaoFactory() {
        this.url = connParams.url + "?" + connParams.timeZone;
        this.username = connParams.username;
        this.password = connParams.password;
    }
    
    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

//        DaoFactory instance = new DaoFactory(
//                "jdbc:mysql://localhost:3306/studentTracer?serverTimezone=UTC", "marc", "marc");
//        return instance;
        DaoFactory instance = new DaoFactory();	
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Récupération du Dao
    public UtilisateurDao getUtilisateurDao() {
        return new UtilisateurDaoImpl(this);
    }
    
    public EleveDAO getEleveDAO() {
    
    return new EleveDAOImpl(this);
    }
    
    public ClasseDao getClasseDAO() {
    	return new ClasseDAOImpl(this);
    }
    public TuteurDAO getTuteurDAO() {
    	return new TuteurDAOImpl(this);
    }
    public CreneauHoraireDAO getCreneauHoraireDAO() {
    	return new CreneauDAOImpl(this);
    }
    public AbscenceDAO getAbscenseDAO() {
    	return new AbscenseDAOImpl(this);
    }
    public SalleDAO getSalleDAO() {
    	return new SalleDAOImpl(this);
    }
    public SequenceDAO getSequenceDAO() {
    	return new SequenceDAOImpl(this);
    }
    public NoteDAO getNoteDAO() {
    	return new NoteDAOImpl(this);
    }
    public CommunicationEEDAO getCommunicationEEDAO() {
    	return new CommunicationEEDAOImpl(this);
    }
    
}
