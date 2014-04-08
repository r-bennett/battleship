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
	
	@Before
	public void buildUp() {
		ac = new AircraftCarrier();
		bs = new Battleship();
		d = new Destroyer();
		es = new EmptySea();
		pb = new PatrolBoat();
		s = new Submarine();				
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

}
