package battleship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class OceanTest {
	Ocean o;
	Ship ac, pb;
	

	@Before
	public void setUp() throws Exception {
		o = new Ocean();
		ac = new AircraftCarrier();
		pb = new PatrolBoat();
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
		assertFalse(o.isOccupied(1, 0));
		ac.placeShipAt(1, 0, true, o);
		assertTrue(o.isOccupied(1, 0));
		assertTrue(o.isOccupied(1, 4));
	}

	@Test
	public void testShootAt() {
		ac.placeShipAt(3, 2, true, o);
		assertTrue(o.shootAt(3, 2));
		assertTrue(o.shootAt(3, 2));
		assertTrue(o.shootAt(3, 3));
		assertTrue(o.shootAt(3, 4));
		assertTrue(o.shootAt(3, 5));
		assertTrue(o.shootAt(3, 6));
		assertFalse(o.shootAt(3, 2));
	}

	@Test
	public void testGetShotsFired() {
		ac.placeShipAt(3, 2, true, o);
		assertEquals(0, o.getShotsFired());
		o.shootAt(3, 2);
		o.shootAt(3, 2);
		assertEquals(2, o.getShotsFired());
		o.shootAt(7, 8);
		assertEquals(3, o.getShotsFired());
		o.shootAt(50, -3);
		assertEquals(3, o.getShotsFired());
	}

	@Test
	public void testGetHitCount() {
		ac.placeShipAt(3, 2, true, o);
		assertEquals(0, o.getHitCount());
		o.shootAt(3, 2);
		assertEquals(1, o.getHitCount());
		o.shootAt(3, 2);
		assertEquals(2, o.getHitCount());
		o.shootAt(3, 3);
		assertEquals(3, o.getHitCount());
		pb.placeShipAt(0, 0, true, o);
		o.shootAt(0, 0);
		assertEquals(4, o.getHitCount());
		o.shootAt(0, 0);
		assertEquals(4, o.getHitCount());
		o.shootAt(9, 9);
		assertEquals(4, o.getHitCount());
	}

	@Test
	public void testGetShipsSunk() {
		pb.placeShipAt(0, 0, true, o);
		ac.placeShipAt(4, 4, false, o);
		
		assertEquals(0, o.getShipsSunk());
		o.shootAt(0, 0);
		assertEquals(1, o.getShipsSunk());
		o.shootAt(0, 0);
		assertEquals(1, o.getShipsSunk());
		
		o.shootAt(4, 4);
		assertEquals(1, o.getShipsSunk());
		o.shootAt(5, 4);
		o.shootAt(6, 4);
		o.shootAt(7, 4);
		o.shootAt(8, 4);
		assertEquals(2, o.getShipsSunk());
	}

	@Test
	public void testIsGameOver() {
		o.placeAllShipsRandomly();
		Random rand = new Random();
		while(o.getShipsSunk()<11) {
			assertFalse(o.isGameOver());
			o.shootAt(rand.nextInt(Ocean.BOARD_SIZE), 
					rand.nextInt(Ocean.BOARD_SIZE));
		}
		assertTrue(o.isGameOver());
	}
}