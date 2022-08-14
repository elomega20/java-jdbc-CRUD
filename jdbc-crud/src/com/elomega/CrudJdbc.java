package com.elomega;

import com.crud.Etudiant;
import com.crud.Module;

public class CrudJdbc {

	public static void main(String[] args) {

		// on cree des etudiants
		Etudiant etudiantEl = new Etudiant("p23  14", "elzo", "123elzo", "el hadji", "sow", "elzo@gmail.com");
		Etudiant etudiantMoussa = new Etudiant("p23  15", "mss", "123mss", "moussa", "diop", "mss@gmail.com");
		Etudiant etudiantLala = new Etudiant("p23  16", "ll", "123ll", "lala", "ba", "ll@gmail.com");
		
		// on cree des modules
		Module moduleAlgebre = new Module("UE237", "Algebre", 5);
		Module moduleAnalyse = new Module("UE238", "Analyse", 5);
		Module moduleCripto  = new Module("UE239", "Criptographie", 5);
		Module moduleJava    = new Module("UE240","Java",6);

		// on insere les etudiants dans la base
		etudiantEl.insererEtudiant();
		etudiantMoussa.insererEtudiant();
		etudiantLala.insererEtudiant();

		// on insere les modules dans la base
		moduleAlgebre.insererModule();
		moduleAnalyse.insererModule();
		moduleCripto.insererModule();
	}

}
