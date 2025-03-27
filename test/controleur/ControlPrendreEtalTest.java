package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {

	private ControlPrendreEtal controlPrendreEtal;
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
	}	
	
	@Test
	void testControlPrendreEtal() {
		assertNotNull(controlPrendreEtal,"Constructeur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		for(int i=0;i<5;i++) {
			assertTrue(controlPrendreEtal.resteEtals());
			Gaulois gaulois = new Gaulois("Gaulois"+i,8);
			village.ajouterHabitant(gaulois);
			village.installerVendeur(gaulois, "", i);
		}
		assertFalse(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		Gaulois bonemine = new Gaulois("Bonemine",100);
		village.ajouterHabitant(bonemine);
		controlPrendreEtal.prendreEtal("Bonemine", "Fleur", 2);
		String[] etatMarche = village.donnerEtatMarche();
		assertEquals("Bonemine",etatMarche[0]);
		assertEquals("2",etatMarche[1]);
		assertEquals("Fleur",etatMarche[2]);
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(controlPrendreEtal.verifierIdentite("Abraracourcix"));
		assertFalse(controlPrendreEtal.verifierIdentite("Bonemine"));
		assertFalse(controlPrendreEtal.verifierIdentite("Asterix"));
		Gaulois bonemine=new Gaulois("Bonemine",3);
		village.ajouterHabitant(bonemine);
		assertTrue(controlPrendreEtal.verifierIdentite("Abraracourcix"));
		assertTrue(controlPrendreEtal.verifierIdentite("Bonemine"));
		assertFalse(controlPrendreEtal.verifierIdentite("Asterix"));
	}

}
