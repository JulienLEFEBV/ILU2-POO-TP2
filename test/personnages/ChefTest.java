package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ChefTest {
	
	private Chef chef;

	@BeforeEach
	public void initialiserSituation() {
		Village village = new Village("le village des irréductibles", 10, 5);
		chef = new Chef("Abraracourcix", 10, village);
		village.setChef(chef);
	}
	
	@Test
	void testPrendreParole() {
		assertEquals(chef.prendreParole(),"Le chef Abraracourcix du village le village des irréductibles : ");
	}

	@Test
	void testChef() {
		assertNotNull(chef);
	}

}
