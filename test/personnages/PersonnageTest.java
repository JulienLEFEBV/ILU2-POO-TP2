package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonnageTest {
	
	private Personnage gaulois;
	
	@BeforeEach
	public void initialiserSituation() {
		gaulois = new Personnage("Gaulois",5);
	}
	
	@Test
	void testPersonnage() {
		assertNotNull(gaulois);
	}

	@Test
	void testGetForce() {
		assertEquals(gaulois.getForce(),5);
	}

	@Test
	void testGetNom() {
		assertEquals(gaulois.getNom(),"Gaulois");
	}

	@Test
	void testToString() {
		assertEquals(gaulois.toString(),"[nom=Gaulois, force=5]");
	}

	@Test
	void testPrendreParole() {
		assertEquals(gaulois.prendreParole(),"Gaulois : ");
	}

}
