package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.connexion.Connecter;

public class InsererDansLaBase {

	public static void insererEtudiant(String codeEtudiant,String login,String passworld,String nom,String prenom,String email) {
		//on recupere l'url , le login et le passworld
		String[] parametreDeConnexion = new String[3];
		parametreDeConnexion = Connecter.parametreConnexion();
		
		String requeteSql = "INSERT INTO etudiant VALUES(?,?,?,?,?,?)";
		//etablissement de la coonnexion et execution de la requete
		try(Connection connexion = DriverManager.getConnection(parametreDeConnexion[0], parametreDeConnexion[1], parametreDeConnexion[2]);
				PreparedStatement preparedStatement = connexion.prepareStatement(requeteSql)){
			
		    preparedStatement.setString(1, codeEtudiant);
		    preparedStatement.setString(2, login);
		    preparedStatement.setString(3, passworld);
		    preparedStatement.setString(4, nom);
		    preparedStatement.setString(5, prenom);
		    preparedStatement.setString(6, email);
		    
		    preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
