package com.test.junit;

import org.junit.jupiter.api.Test;

import com.crud.Etudiant;

class SupprimerEtudiantTest {

	@Test
	void supprimeretudiantTest() {
		Etudiant etudiant = new Etudiant("p26 118", "jemy","123","Bond","James", "jemy@gmail.com");
		etudiant.supprimerEtudiant();
	}

}
