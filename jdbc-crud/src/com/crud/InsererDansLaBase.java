package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.connexion.Connecter;

public class InsererDansLaBase {

	public static void insererEtudiant(String codeEtudiant,String login,String passworld,String nom,String prenom,String email) {
		
		String[] parametreDeConnexion = new String[3];
		parametreDeConnexion = Connecter.parametreConnexion();
		
		try(Connection connexion = DriverManager.getConnection(parametreDeConnexion[0], parametreDeConnexion[1], parametreDeConnexion[2])){
			System.out.println("Connection etablie avec succes");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
