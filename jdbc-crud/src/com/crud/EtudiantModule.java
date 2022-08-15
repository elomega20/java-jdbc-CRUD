package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connexion.Connecter;

public class EtudiantModule {
	private String codeEtudiant;
	private String codeModule;
	
	public EtudiantModule(String codeEtudiant,String codeModule) {
		this.codeEtudiant = codeEtudiant;
		this.codeModule = codeModule;
	}
	
    public void insererEtudiantModule() {
    	// on recupere l'url , le login et le passworld
		String[] parametreDeConnexion = new String[3];
		parametreDeConnexion = Connecter.parametreConnexion();

		String requeteSql = "INSERT INTO etudiant_module(codeEtudiant,codeModule) VALUES(?,?)";
		// etablissement de la coonnexion et execution de la requete
		try (Connection connexion = DriverManager.getConnection(parametreDeConnexion[0], parametreDeConnexion[1],
				parametreDeConnexion[2]);
				PreparedStatement preparedStatement = connexion.prepareStatement(requeteSql)) {

			preparedStatement.setString(1, this.codeEtudiant);
			preparedStatement.setString(2, this.codeModule);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
