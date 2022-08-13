package com.test.junit;

import org.junit.jupiter.api.Test;

import com.crud.Etudiant;

class MettreAjourEmailEtudiantTest {

	@Test
	void mettreAjourEmailEtudiantTest() {
		Etudiant etudiant = new Etudiant("p26 118", "jemy", "123", "Bond", "James", "jemy@gmail.com");
		etudiant.miseAjourEmailEtudiant("jemytech@gmail.com");
	}

}
