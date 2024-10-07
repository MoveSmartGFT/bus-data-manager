package com.busDataManager;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.jmolecules.archunit.JMoleculesArchitectureRules;
import org.jmolecules.archunit.JMoleculesDddRules;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

@AnalyzeClasses(packages =
		{"busDataManager.core", "busDataManager.notification", "busDataManager.passenger",
				"busDataManager.route", "busDataManager.vehicle"})
class ArchitectureTests {

	@ArchTest
	ArchRule dddRules = JMoleculesDddRules.all();

	@ArchTest
	ArchRule onion = JMoleculesArchitectureRules.ensureOnionSimple();

	@Test
	void verifiesModularStructure() {
		ApplicationModules modules = ApplicationModules.of(Application.class);
		modules.forEach(System.out::println);
		modules.verify();
	}
}
