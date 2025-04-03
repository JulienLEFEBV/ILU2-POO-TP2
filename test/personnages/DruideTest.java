package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DruideTest {
	
	private Druide druide;
	
	@BeforeEach
	public void initialiserSituation() {
		druide = new Druide("Druide",5,10,50);
	}
	
	@Test
	void testPrendreParole() {
		assertEquals(druide.prendreParole(), "Le druide Druide : ");
	}

	@Test
	void testDruide() {
		assertNotNull(druide);
	}

	@Test
	void testBooster() {
		Gaulois gaulois = new Gaulois("Gaulois",1);
		druide.booster(gaulois);
		assertEquals(gaulois.toString(),"Gaulois [nom=Gaulois, force=1, effetPotion=1]");
	}

}
