package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	
	private ControlVerifierIdentite controlVerifierIdentite;
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}	
	
	@Test
	void testControlVerifierIdentite() {
		assertNotNull(controlVerifierIdentite, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(controlVerifierIdentite.verifierIdentite("Abraracourcix"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Bonemine"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Asterix"));
		Gaulois bonemine=new Gaulois("Bonemine",3);
		village.ajouterHabitant(bonemine);
		assertTrue(controlVerifierIdentite.verifierIdentite("Abraracourcix"));
		assertTrue(controlVerifierIdentite.verifierIdentite("Bonemine"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Asterix"));
	}

}
