package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	
	private ControlAcheterProduit controlAcheterProduit;
	private Village village;
	private Chef abraracourcix;
	
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
	}
	
	@Test
	void testControlAcheterProduit() {
		assertNotNull(controlAcheterProduit,"Constructeur ne renvoie pas null");
	}
	
	
	@Test
	void testAcheterProduit() {
		assertEquals(controlAcheterProduit.acheterProduit("Bonemine", 10),0);
		Gaulois bonemine=new Gaulois("Bonemine",3);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "Fleur", 10);
		assertEquals(controlAcheterProduit.acheterProduit("Bonemine", 5),5);
		assertEquals(controlAcheterProduit.acheterProduit("Bonemine", 10),5);
		assertEquals(controlAcheterProduit.acheterProduit("Bonemine", 100),0);
		
		
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(controlAcheterProduit.verifierIdentite("Abraracourcix"));
		assertFalse(controlAcheterProduit.verifierIdentite("Bonemine"));
		assertFalse(controlAcheterProduit.verifierIdentite("Asterix"));
		Gaulois bonemine=new Gaulois("Bonemine",3);
		village.ajouterHabitant(bonemine);
		assertTrue(controlAcheterProduit.verifierIdentite("Abraracourcix"));
		assertTrue(controlAcheterProduit.verifierIdentite("Bonemine"));
		assertFalse(controlAcheterProduit.verifierIdentite("Asterix"));
	}

	@Test
	void testTrouverProduit() {
		assertNull(controlAcheterProduit.trouverProduit("Fleur"));
		assertNull(controlAcheterProduit.trouverProduit("Sanglier"));
		Gaulois bonemine=new Gaulois("Bonemine",3);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "Fleur", 10);
		assertEquals(controlAcheterProduit.trouverProduit("Fleur")[0],"Bonemine");
		assertNull(controlAcheterProduit.trouverProduit("Sanglier"));
		Gaulois asterix=new Gaulois("Asterix",8);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "Fleur", 10);
		assertEquals(controlAcheterProduit.trouverProduit("Fleur")[0],"Bonemine");
		assertEquals(controlAcheterProduit.trouverProduit("Fleur")[1],"Asterix");
		assertNull(controlAcheterProduit.trouverProduit("Sanglier"));
	}

}
