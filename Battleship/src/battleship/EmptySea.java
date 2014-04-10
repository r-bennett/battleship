package battleship;

/**
 * @author Bennett_Richard
 * 
 */
public class EmptySea extends Ship {

	/**
	 * Initialises the length and hit[] fields
	 */
	public EmptySea() {
		length = 1;
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
		return "Empty Sea";
	}

	/**
	 * Always returns false, regardless
	 * 
	 * @param row
	 *            target row
	 * @param column
	 *            target column
	 */
	@Override
	public boolean shootAt(int row, int column) {
		return false;
	}

	/**
	 * Always returns "-"
	 */
	@Override
	public String toString() {
		return "-";
	}

}
