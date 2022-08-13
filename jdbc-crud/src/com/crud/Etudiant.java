package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connexion.Connecter;

public class Etudiant {
	
	private String codeEtudiant;
	private String login;
	private String passworld;
	private String nom;
	private String prenom;
	private String email;
	
	//constructeur
	public Etudiant(String codeEtudiant,String login,String passworld,String nom,String prenom,String email){
		this.codeEtudiant = codeEtudiant;
		this.login = login;
		this.passworld = passworld;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	
	//insert les informations de l'etudiant dans la base de donnee
	public void insererEtudiant() {
		//on recupere l'url , le login et le passworld
		String[] parametreDeConnexion = new String[3];
		parametreDeConnexion = Connecter.parametreConnexion();
		
		String requeteSql = "INSERT INTO etudiant VALUES(?,?,?,?,?,?)";
		//etablissement de la coonnexion et execution de la requete
		try(Connection connexion = DriverManager.getConnection(parametreDeConnexion[0], parametreDeConnexion[1], parametreDeConnexion[2]);
				PreparedStatement preparedStatement = connexion.prepareStatement(requeteSql)){
			
		    preparedStatement.setString(1, this.codeEtudiant);
		    preparedStatement.setString(2, this.login);
		    preparedStatement.setString(3, this.passworld);
		    preparedStatement.setString(4, this.nom);
		    preparedStatement.setString(5, this.prenom);
		    preparedStatement.setString(6, this.email);
		    
		    preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//affiche les informations de l'etudiant
	public Boolean afficherEtudiant() {
		//on recupere l'url , le login et le passworld
		String[] parametreDeConnexion = new String[3];
		parametreDeConnexion = Connecter.parametreConnexion();
		
		 Boolean trouver = false;
		
		String requeteSql = "SELECT * FROM etudiant WHERE codeEtudiant=?";
		//etablissement de la coonnexion et execution de la requete
		try(Connection connexion = DriverManager.getConnection(parametreDeConnexion[0], parametreDeConnexion[1], parametreDeConnexion[2]);
				PreparedStatement preparedStatement = connexion.prepareStatement(requeteSql)){
			
		    preparedStatement.setString(1, this.codeEtudiant);
		    
		    ResultSet resultSet =  preparedStatement.executeQuery();
		    if(resultSet.next()) {
		    	trouver = true;
		    	System.out.println("Nom: "+resultSet.getString("nom"));
			    System.out.println("Prenom: "+resultSet.getString("prenom"));
			    System.out.println("Email: "+resultSet.getString("email"));	
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return trouver;
	}
	
}
