package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	
	private ControlAfficherVillage controlAfficherVillage;
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}	
	
	@Test
	void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage);
	}

	@Test
	void testDonnerNomsVillageois() {
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[0],"Abraracourcix");
		Gaulois bonemine = new Gaulois("Bonemine",3);
		village.ajouterHabitant(bonemine);
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[0],"Abraracourcix");
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[1],"Bonemine");
		Druide panoramix = new Druide("Panoramix",1,5,10);
		village.ajouterHabitant(panoramix);
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[0],"Abraracourcix");
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[1],"Bonemine");
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[2],"le druide Panoramix");
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(controlAfficherVillage.donnerNomVillage(), "le village des irréductibles");
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(controlAfficherVillage.donnerNbEtals(),5);
	}

}
