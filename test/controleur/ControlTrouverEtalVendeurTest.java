package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {

	private ControlTrouverEtalVendeur controlTrouverEtalVendeur ;
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	}	
	
	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(controlTrouverEtalVendeur,"Constructeur ne renvoie pas null");
	}

	@Test
	void testTrouverEtalVendeur() {
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine"));
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Obelix"));
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "Fleur", 75);
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Obelix"));
		assertEquals(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine").getVendeur(),bonemine);
	}

}
