package com.test.junit;

import org.junit.jupiter.api.Test;
import com.crud.EtudiantModule;

class InsererEtudiantModuleTest {

	@Test
	void insererEtudiantModuleTest() {
        EtudiantModule etudModule = new EtudiantModule("p26 118","UE326");
        etudModule.insererEtudiantModule();
	}

}
