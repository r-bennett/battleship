package battleship;

/**
 * @author Bennett_Richard
 *
 */
public class Destroyer extends Ship {
	
	/**
	 *  Initialises the length and hit[] fields
	 */
	public Destroyer() {
		length = 2;
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
		return "Destroyer";
	}

}
