package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShipTest {
	public Ship ac;
	public Ship bs;
	public Ship d;
	public Ship es;
	public Ship pb;
	public Ship s;
	public Ocean o;
	
	@Before
	public void buildUp() {
		ac = new AircraftCarrier();
		bs = new Battleship();
		d = new Destroyer();
		es = new EmptySea();
		pb = new PatrolBoat();
		s = new Submarine();
		o = new Ocean();
	}

	@Test
	public void getLengthTest() {
		assertEquals(ac.getLength(),5);
		assertEquals(bs.getLength(),4);
		assertEquals(d.getLength(),2);
		assertEquals(es.getLength(),1);
		assertEquals(pb.getLength(),1);
		assertEquals(s.getLength(),3);
	}
	
	@Test
	public void bowColumnTest() {
		ac.setBowColumn(0);
		assertEquals(ac.getBowColumn(),0);
		ac.setBowColumn(9);
		assertEquals(ac.getBowColumn(),9);
	}
	
	@Test
	public void bowRowTest() {
		ac.setBowRow(0);
		assertEquals(ac.getBowRow(),0);
		ac.setBowRow(9);
		assertEquals(ac.getBowRow(),9);
	}
	
	@Test
	public void getShipTypeTest() {
		assertEquals(ac.getShipType(),"Aircraft Carrier");
		assertEquals(bs.getShipType(),"Battleship");
		assertEquals(d.getShipType(),"Destroyer");
		assertEquals(es.getShipType(),"Empty Sea");
		assertEquals(pb.getShipType(),"Patrol Boat");
		assertEquals(s.getShipType(),"Submarine");
	}
	
	@Test
	public void horizontalTest() {
		ac.setHorizontal(true);
		assertTrue(ac.isHorizontal());
		ac.setHorizontal(false);
		assertFalse(ac.isHorizontal());
	}
	
	@Test
	public void isSunkTest() {
		pb.setBowRow(2);
		pb.setBowColumn(3);
		pb.setHorizontal(true);
		assertFalse(pb.isSunk());
		pb.shootAt(2, 3);
		assertTrue(pb.isSunk());
		
		d.setBowRow(6);
		d.setBowColumn(3);
		d.setHorizontal(true);
		assertFalse(d.isSunk());
		d.shootAt(6,3);
		assertFalse(d.isSunk());
		d.shootAt(6,4);
		assertTrue(d.isSunk());		
	}
	
	@Test
	public void okToPlaceShipAtTest() {
		ac.placeShipAt(0,0,true,o);
		assertFalse(bs.okToPlaceShipAt(0,0,true,o));
		assertFalse(bs.okToPlaceShipAt(1,0,true,o));
		assertFalse(bs.okToPlaceShipAt(1,5,true,o));
		assertFalse(bs.okToPlaceShipAt(0,5,false,o));
		assertTrue(bs.okToPlaceShipAt(0, 6, false, o));
		assertTrue(bs.okToPlaceShipAt(6,0,true,o));
	}

}
