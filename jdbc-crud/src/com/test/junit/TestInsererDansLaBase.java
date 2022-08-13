package com.test.junit;

import org.junit.jupiter.api.Test;
import com.crud.InsererDansLaBase;

class TestInsererDansLaBase {

	@Test
	void testInsererEtudiant() {
	    InsererDansLaBase.insererEtudiant("p24 118", "jemy","123","Bond","James", "jemy@gmail.com");
	}

}
