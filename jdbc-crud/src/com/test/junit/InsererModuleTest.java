package com.test.junit;

import com.crud.Module;

import org.junit.jupiter.api.Test;

class InsererModuleTest {

	@Test
	void insererModuleTest() {
        Module module =  new Module("UE326","Algebre",5);
        module.insererModule();
	}

}
