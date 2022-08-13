package com.connexion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Connecter {
	
	//cette method renvoie un tableau contenant l'url , le login et le passworld
     public static String[] parametreConnexion() {
    	String[] parametre =  new String[3];
    	Properties props = new Properties();
 		try (FileInputStream file = new FileInputStream("model/conf.properties")) { // on charge le fichier
 																					// conf.properties
 			props.load(file);
 		} catch (FileNotFoundException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 		
 	    // on charge le pilote mysql-connector
 		try {
 			Class.forName(props.getProperty("jdbc.driver.class"));
 		} catch (ClassNotFoundException e) {
 			e.printStackTrace();
 		} 

 		// on charge l'url , le login et le passworld
 		String url = props.getProperty("jdbc.url");
 		String dbLogin = props.getProperty("jdbc.login");
 		String dbPassworld = props.getProperty("jdbc.passworld");
 		
 		parametre[0] = url;
 		parametre[1] = dbLogin;
 		parametre[2] = dbPassworld;
 		
 		return parametre;

     }
     
}
