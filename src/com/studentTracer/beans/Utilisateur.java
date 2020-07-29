package com.studentTracer.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilisateur {
private Long id;
private String nom;
private String prenom;
private String matiere;
private char sexe;
private String username;
private String mdp;
private String telephone;

public String getTelephone(){
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	

		this.nom = nom;	
	
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getMatiere() {
	return matiere;
}
public void setMatiere(String matiere) {
	this.matiere = matiere;
}
public char getSexe() {
	return sexe;
}
public void setSexe(char sexe) {
	this.sexe = sexe;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getMdp() {
	return mdp;
}
public void setMdp(String mdp) {
	this.mdp = mdp;
}

public void ajouterUser() {
	/* Chargement du driver JDBC pour MySQL */
	try {
	Class.forName( "com.mysql.jdbc.Driver" );
	} catch ( ClassNotFoundException e ) {
	/* Gérer les éventuelles erreurs ici. */
		System.out.println("classe for:: "+e.getMessage());
	}
	
	/* Connexion à la base de données */
	String url = "jdbc:mysql://localhost:3306/studentTracer?serverTimezone=UTC";
	String utilisateur = "marc";
	String motDePasse = "marc";
	Connection connexion = null;
	try {
	connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
	/* Ici, nous placerons nos requêtes vers la BDD */
	/* ... */
	Statement statement = connexion.createStatement();
	ResultSet resultat = statement.executeQuery( "SELECT * FROM Classe;" );
	while(resultat.next()) {
		System.out.println(resultat.getInt("id_classe")+" "+resultat.getString("libelle_classe"));
	}
	} catch ( SQLException e ) {
	/* Gérer les éventuelles erreurs ici */
		System.out.println("connection refusée "+e.getMessage());
	} finally {
	if ( connexion != null )
	try {
	/* Fermeture de la connexion */
	connexion.close();
	} catch ( SQLException ignore ) {
	/* Si une erreur survient lors de la fermeture, il
	suffit de l'ignorer. */
		System.out.println(ignore.getMessage());
	}
	}
}
}
