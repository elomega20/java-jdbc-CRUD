package com.test.junit;

import org.junit.jupiter.api.Test;

import com.crud.Etudiant;
import com.crud.EtudiantModule;
import com.crud.Module;

class InsererEtudiantModuleTest {

	@Test
	void insererEtudiantModuleTest() {
		
		Etudiant etudiant = new Etudiant("p26 118", "jemy","123","Bond","James", "jemy@gmail.com");
		Module module =  new Module("UE326","Algebre",5);
        
		
		EtudiantModule regle1 = new EtudiantModule(etudiant.getCodeEtudiant(),module.getCodeModule());
		regle1.insererEtudiantModule();
		
	}

}
