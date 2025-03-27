package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	
	private ControlLibererEtal controlLibererEtal;
	private Village village;
	private Chef abraracourcix;
	
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
	}
	
	@Test
	void testControlLibererEtal() {
		assertNotNull(controlLibererEtal,"Constructeur ne renvoie pas null");
	}

	@Test
	void testIsVendeur() {
		assertFalse(controlLibererEtal.isVendeur("Bonemine"));
		Gaulois bonemine = new Gaulois("Bonemine",1);
		village.ajouterHabitant(bonemine);
		assertFalse(controlLibererEtal.isVendeur("Bonemine"));
		village.installerVendeur(bonemine, "Fleur", 4);
		assertTrue(controlLibererEtal.isVendeur("Bonemine"));
	}

	@Test
	void testLibererEtal() {
		assertFalse(controlLibererEtal.isVendeur("Bonemine"));
		assertNull(controlLibererEtal.libererEtal("Bonemine"));
		Gaulois bonemine = new Gaulois("Bonemine",1);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "Fleur", 4);
		assertTrue(controlLibererEtal.isVendeur("Bonemine"));
		assertEquals(controlLibererEtal.libererEtal("Bonemine")[1],"Bonemine");
		assertFalse(controlLibererEtal.isVendeur("Bonemine"));
	}

}
