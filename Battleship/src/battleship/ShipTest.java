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
	
	

}
