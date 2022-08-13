package com.test.junit;

import org.junit.jupiter.api.Test;
import com.crud.Module;

class SupprimerModuleTest {

	@Test
	void supprimerModuleTest() {
		 Module module =  new Module("UE326","Algebre",5);
		 module.supprimerModule();
	}

}
