package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {

	
	private ControlAfficherMarche controlAfficherMarche;
	private Village village;
	private Chef abraracourcix;
	
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherMarche = new ControlAfficherMarche(village);
	}
	
	@Test
	void testControlAfficherMarche() {
		assertNotNull(controlAfficherMarche);
	}

	@Test
	void testDonnerInfosMarche() {
		Gaulois bonemine = new Gaulois("Bonemine",4);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "Fleur", 80);
		String[] etatMarche=controlAfficherMarche.donnerInfosMarche();
		assertEquals(etatMarche[0],"Bonemine");
		assertEquals(etatMarche[1], "80");
		assertEquals(etatMarche[2],"Fleur");
	}

}
