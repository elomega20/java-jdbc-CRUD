package com.test.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.crud.Etudiant;

class AfficherEtudiantTest {

	@Test
	void afficherEtudiantTest() {
		Etudiant etudiant = new Etudiant("p26 118", "jemy","123","Bond","James", "jemy@gmail.com");
		Boolean resultat = etudiant.afficherEtudiant();
		assertEquals(true, resultat);
	}

}
