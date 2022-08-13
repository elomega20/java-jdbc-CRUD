package com.test.junit;

import org.junit.jupiter.api.Test;

import com.crud.Etudiant;

class InsererEtudiantTest {

	@Test
	void insererEtudiantTest() {
		Etudiant etudiant = new Etudiant("p26 118", "jemy","123","Bond","James", "jemy@gmail.com");
		etudiant.insererEtudiant();
	}

}
