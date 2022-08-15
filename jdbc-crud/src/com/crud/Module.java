package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connexion.Connecter;

public class Module {
	private String codeModule;
	private String libelle;
	private int credit;
	

	public String getCodeModule() {
		return codeModule;
	}

	public void setCodeModule(String codeModule) {
		this.codeModule = codeModule;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	// constructeur
	public Module(String codeModule, String libelle, int credit) {
		this.codeModule = codeModule;
		this.libelle = libelle;
		this.credit = credit;
	}

	// insert un module
	public void insererModule() {
		// on recupere l'url , le login et le passworld
		String[] parametreDeConnexion = new String[3];
		parametreDeConnexion = Connecter.parametreConnexion();

		String requeteSql = "INSERT INTO module VALUES(?,?,?)";
		// etablissement de la coonnexion et execution de la requete
		try (Connection connexion = DriverManager.getConnection(parametreDeConnexion[0], parametreDeConnexion[1],
				parametreDeConnexion[2]);
				PreparedStatement preparedStatement = connexion.prepareStatement(requeteSql)) {

			preparedStatement.setString(1, this.codeModule);
			preparedStatement.setString(2, this.libelle);
			preparedStatement.setInt(3, this.credit);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// afficher un module
	public Boolean afficherModule() {
		// on recupere l'url , le login et le passworld
		String[] parametreDeConnexion = new String[3];
		parametreDeConnexion = Connecter.parametreConnexion();

		Boolean trouver = false;

		String requeteSql = "SELECT * FROM module WHERE codeModule=?";
		// etablissement de la coonnexion et execution de la requete
		try (Connection connexion = DriverManager.getConnection(parametreDeConnexion[0], parametreDeConnexion[1],
				parametreDeConnexion[2]);
				PreparedStatement preparedStatement = connexion.prepareStatement(requeteSql)) {

			preparedStatement.setString(1, this.codeModule);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				trouver = true;
				System.out.println("Code Module: " + resultSet.getString("codeModule"));
				System.out.println("Libelle: " + resultSet.getString("libelle"));
				System.out.println("Credit: " + resultSet.getInt("credit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return trouver;
	}

	// supprimer un module
	public void supprimerModule() {
		// on recupere l'url , le login et le passworld
		String[] parametreDeConnexion = new String[3];
		parametreDeConnexion = Connecter.parametreConnexion();

		String requeteSql = "DELETE FROM module WHERE codeModule=?";
		// etablissement de la coonnexion et execution de la requete
		try (Connection connexion = DriverManager.getConnection(parametreDeConnexion[0], parametreDeConnexion[1],
				parametreDeConnexion[2]);
				PreparedStatement preparedStatement = connexion.prepareStatement(requeteSql)) {

			preparedStatement.setString(1, this.codeModule);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// mettre a jour le credit d'un module
	public void miseAjourCreditModule(int nouveauCredit) {
		this.credit = nouveauCredit;
		// on recupere l'url , le login et le passworld
		String[] parametreDeConnexion = new String[3];
		parametreDeConnexion = Connecter.parametreConnexion();

		String requeteSql = "UPDATE module SET credit=? WHERE codeModule=?";
		// etablissement de la coonnexion et execution de la requete
		try (Connection connexion = DriverManager.getConnection(parametreDeConnexion[0], parametreDeConnexion[1],
				parametreDeConnexion[2]);
				PreparedStatement preparedStatement = connexion.prepareStatement(requeteSql)) {

			preparedStatement.setInt(1, this.credit);
			preparedStatement.setString(2, this.codeModule);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
