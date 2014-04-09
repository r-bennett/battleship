package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OceanTest {
	Ocean o;

	@Before
	public void setUp() throws Exception {
		o = new Ocean();
	}

	@Test
	public void testOcean() {
		Ship[][] shipArray = o.getShipArray();
		for(int i=0 ; i<Ocean.BOARD_SIZE ; i++) {
			for(int j=0 ; j<Ocean.BOARD_SIZE ; j++) {
				assertEquals(shipArray[i][j].getClass(),new EmptySea().getClass());
			}
		}
		assertEquals(o.getHitCount(),0);
		assertEquals(o.getShotsFired(),0);
		assertEquals(o.getShipsSunk(),0);
		assertFalse(o.isGameOver());
	}

	@Test
	public void testPlaceAllShipsRandomly() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsOccupied() {
		fail("Not yet implemented");
	}

	@Test
	public void testShootAt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetShotsFired() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHitCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetShipsSunk() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsGameOver() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetShipArray() {
		fail("Not yet implemented");
	}

}
