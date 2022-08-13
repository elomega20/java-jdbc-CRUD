package com.test.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.crud.Module;

class AfficherModuleTest {

	@Test
	void afficherModuleTest() {
		Module module = new Module("UE325", "Analyse", 5);
		Boolean trouver =  module.afficherModule();
		assertEquals(true, trouver);
	}

}
