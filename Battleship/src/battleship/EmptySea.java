package battleship;

/**
 * @author Bennett_Richard
 *
 */
public class EmptySea extends Ship {

	/**
	 * 
	 */
	public EmptySea() {
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
		return "Empty Sea";
	}

	/* (non-Javadoc)
	 * @see battleship.Ship#shootAt(int, int)
	 */
	@Override
	public boolean shootAt(int row, int column) {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see battleship.Ship#toString()
	 */
	@Override
	public String toString() {
		return "-";
	}

}
