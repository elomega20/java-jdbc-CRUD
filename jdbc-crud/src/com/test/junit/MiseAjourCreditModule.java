package com.test.junit;

import org.junit.jupiter.api.Test;
import com.crud.Module;

class MiseAjourCreditModule {

	@Test
	void miseAjourCreditModuleTest() {
		Module module = new Module("UE325", "Analyse", 5);
		module.miseAjourCreditModule(6);
	}

}
