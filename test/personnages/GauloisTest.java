package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GauloisTest {
	
	private Gaulois gaulois;
	
	@BeforeEach
	public void initialiserSituation() {
		gaulois = new Gaulois("Gaulois",5);
	}

	@Test
	void testToString() {
		assertEquals(gaulois.toString(),"Gaulois [nom=Gaulois, force=5, effetPotion=1]");
	}

	@Test
	void testGaulois() {
		assertNotNull(gaulois);
	}

	@Test
	void testBoirePotion() {
		assertEquals(gaulois.toString(),"Gaulois [nom=Gaulois, force=5, effetPotion=1]");
		gaulois.boirePotion(10);
		assertEquals(gaulois.toString(),"Gaulois [nom=Gaulois, force=5, effetPotion=10]");
	}
	
	@Test
	void testPrendreParole() {
		assertEquals(gaulois.prendreParole(),"Le gaulois Gaulois : ");
	}

}
