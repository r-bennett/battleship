package battleship;

/**
 * @author Bennett_Richard
 * 
 */
public class Battleship extends Ship {

	/**
	 * Initialises the length and hit[] fields
	 */
	public Battleship() {
		length = 4;
		hit = new boolean[length];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see battleship.Ship#getLength()
	 */
	@Override
	public int getLength() {
		return length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see battleship.Ship#getShipType()
	 */
	@Override
	public String getShipType() {
		return "Battleship";
	}

}
