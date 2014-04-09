package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OceanTest {
	Ocean o;
	Ship ac;

	@Before
	public void setUp() throws Exception {
		o = new Ocean();
		ac = new AircraftCarrier();
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
		// check correct number of occupied spaces
		int shipCount = 0;
		o.placeAllShipsRandomly();
		for(int i=0 ; i<Ocean.BOARD_SIZE ; i++) {
			for(int j=0 ; j<Ocean.BOARD_SIZE ; j++) {
				if(o.isOccupied(i, j))
					shipCount++;
			}
		}
		assertEquals(shipCount,(5 + 2*4 + 2*3 + 2*2 + 4*1));
		
		//check no diagonally adjacent ships
		for(int i=0 ; i<Ocean.BOARD_SIZE ; i++) {
			for(int j=0 ; j<Ocean.BOARD_SIZE ; j++) {
				if(o.isOccupied(i, j)) {
					for(int x=i-1 ; x<=i+1 ; x=x+2) {
						if(x<0 || x>=Ocean.BOARD_SIZE)
							continue;
						for(int y=j-1 ; y<=j+1 ; y=y+2) {
							if(y<0 || y>=Ocean.BOARD_SIZE)
								continue;
							if(o.isOccupied(x, y))
								fail("Diagonally adjacent ships at ("
										+ i + ", " + j + "), (" + x + ", " + y + ")");
						}
					}
				}
			}
		}
	}

	@Test
	public void testIsOccupied() {
		assertFalse(o.isOccupied(0, 0));
		ac.placeShipAt(0, 0, true, o);
		assertTrue(o.isOccupied(0, 0));
		assertTrue(o.isOccupied(0, 4));
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
