package battleship;

/**
 * @author Bennett_Richard
 *
 */
public class PatrolBoat extends Ship {

	/**
	 *  Initialises the length and hit[] fields
	 */
	public PatrolBoat() {
		length = 1;
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
		return "Patrol Boat";
	}

}
