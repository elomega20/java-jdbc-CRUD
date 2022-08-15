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
	
	public String getCodeEtudiant() {
		return codeEtudiant;
	}

	public void setCodeEtudiant(String codeEtudiant) {
		this.codeEtudiant = codeEtudiant;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassworld() {
		return passworld;
	}

	public void setPassworld(String passworld) {
		this.passworld = passworld;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	// constructeur
	public Etudiant(String codeEtudiant, String login, String passworld, String nom, String prenom, String email) {
		this.codeEtudiant = codeEtudiant;
		this.login = login;
		this.passworld = passworld;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	// insert les informations de l'etudiant dans la base de donnee
	public void insererEtudiant() {
		// on recupere l'url , le login et le passworld
		String[] parametreDeConnexion = new String[3];
		parametreDeConnexion = Connecter.parametreConnexion();

		String requeteSql = "INSERT INTO etudiant VALUES(?,?,?,?,?,?)";
		// etablissement de la coonnexion et execution de la requete
		try (Connection connexion = DriverManager.getConnection(parametreDeConnexion[0], parametreDeConnexion[1],
				parametreDeConnexion[2]);
				PreparedStatement preparedStatement = connexion.prepareStatement(requeteSql)) {

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

	// affiche les informations de l'etudiant
	public Boolean afficherEtudiant() {
		// on recupere l'url , le login et le passworld
		String[] parametreDeConnexion = new String[3];
		parametreDeConnexion = Connecter.parametreConnexion();

		Boolean trouver = false;

		String requeteSql = "SELECT * FROM etudiant WHERE codeEtudiant=?";
		// etablissement de la coonnexion et execution de la requete
		try (Connection connexion = DriverManager.getConnection(parametreDeConnexion[0], parametreDeConnexion[1],
				parametreDeConnexion[2]);
				PreparedStatement preparedStatement = connexion.prepareStatement(requeteSql)) {

			preparedStatement.setString(1, this.codeEtudiant);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				trouver = true;
				System.out.println("Nom: " + resultSet.getString("nom"));
				System.out.println("Prenom: " + resultSet.getString("prenom"));
				System.out.println("Email: " + resultSet.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return trouver;
	}

	// pour supprimer un etudiant
	public void supprimerEtudiant() {
		// on recupere l'url , le login et le passworld
		String[] parametreDeConnexion = new String[3];
		parametreDeConnexion = Connecter.parametreConnexion();

		String requeteSql = "DELETE FROM etudiant WHERE codeEtudiant=?";
		// etablissement de la coonnexion et execution de la requete
		try (Connection connexion = DriverManager.getConnection(parametreDeConnexion[0], parametreDeConnexion[1],
				parametreDeConnexion[2]);
				PreparedStatement preparedStatement = connexion.prepareStatement(requeteSql)) {

			preparedStatement.setString(1, this.codeEtudiant);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// mettre a jour l'email de l'etudiant
	public void miseAjourEmailEtudiant(String nouveauEmail) {
		this.email = nouveauEmail;
		// on recupere l'url , le login et le passworld
		String[] parametreDeConnexion = new String[3];
		parametreDeConnexion = Connecter.parametreConnexion();

		String requeteSql = "UPDATE etudiant SET email=? WHERE codeEtudiant=?";
		// etablissement de la coonnexion et execution de la requete
		try (Connection connexion = DriverManager.getConnection(parametreDeConnexion[0], parametreDeConnexion[1],
				parametreDeConnexion[2]);
				PreparedStatement preparedStatement = connexion.prepareStatement(requeteSql)) {

			preparedStatement.setString(1, this.email);
			preparedStatement.setString(2, this.codeEtudiant);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
