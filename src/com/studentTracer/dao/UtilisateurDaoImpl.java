package com.studentTracer.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UtilisateurDaoImpl implements UtilisateurDao {
    private DaoFactory daoFactory;

    UtilisateurDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter() {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO Classe(id_classe, libelle_classe) VALUES(?, ?);");
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "ppppp");

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    }
