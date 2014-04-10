package battleship;

/**
 * @author Bennett_Richard
 *
 */
public class AircraftCarrier extends Ship {
	
	/**
	 * 
	 */
	public AircraftCarrier() {
		length = 5;
		hit = new boolean[length];
	}

	/* (non-Javadoc)
	 * @see battleship.Ship#getLength()
	 */
	@Override
	public int getLength() {
		return length;
	}

	/* (non-Javadoc)
	 * @see battleship.Ship#getShipType()
	 */
	@Override
	public String getShipType() {
		return "Aircraft Carrier";
	}

}
