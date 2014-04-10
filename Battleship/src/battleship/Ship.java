package battleship;

/**
 * @author Bennett_Richard
 *
 */
public abstract class Ship {

	protected int length;
	private int bowRow;
	private int bowColumn;
	private boolean horizontal;
	protected boolean[] hit;

	/**
	 * @return length
	 */
	public abstract int getLength();

	/**
	 * @return bowRow
	 */
	public int getBowRow() {
		return bowRow;
	}

	/**
	 * @return bowColumn
	 */
	public int getBowColumn() {
		return bowColumn;
	}

	/**
	 * @return horizontal
	 */
	public boolean isHorizontal() {
		return horizontal;
	}

	/**
	 * @param row row to set bow at
	 */
	public void setBowRow(int row) {
		bowRow = row;
	}

	/**
	 * @param column column to set bow at
	 */
	public void setBowColumn(int column) {
		bowColumn = column;
	}

	/**
	 * @param horizontal value to assign to horizontal
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * @return name of ship, e.g. "Patrol Boat"
	 */
	public abstract String getShipType();

	/**
	 * Checks if a ship can be placed in a given position,
	 * but does not alter state of ship or ocean
	 * 
	 * @param row target row
	 * @param column target column
	 * @param horizontal ship's orientation
	 * @param ocean ocean to place in
	 * @return true if ship can be placed in given way,
	 * without being adjacent to an existing ship 
	 * (including diagonally), false otherwise
	 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		if(horizontal) {
			// check in bounds
			if(column<0 || column>Ocean.BOARD_SIZE-length 
					|| row<0 || row>=Ocean.BOARD_SIZE) {
				return false;
			}
			// check no ships around
			for(int i=column-1 ; i<=column+length  ; i++) {
				if(i<0 || i>=Ocean.BOARD_SIZE) 
					continue;
				for(int j=row-1 ; j<=row+1 ; j++) {
					if(j<0 || j>=Ocean.BOARD_SIZE)
						continue;
					if(ocean.isOccupied(j,i)) {
						return false;
					}
				}
			}
		} else {
			// check in bounds
			if(column<0 || column>=Ocean.BOARD_SIZE
					|| row<0 || row>Ocean.BOARD_SIZE-length) {
				return false;
			}
			// check no ships around
			for(int i=column-1 ; i<=column+1 ; i++) {
				if(i<0 || i>=Ocean.BOARD_SIZE) 
					continue;
				for(int j=row-1 ; j<=row+length ; j++) {
					if(j<0 || j>=Ocean.BOARD_SIZE)
						continue;
					if(ocean.isOccupied(j,i)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Places the ship at the given position in the given ocean.
	 * Note: method does not check for the validity of this position.
	 * 
	 * @param row target bow row
	 * @param column target bow column
	 * @param horizontal ship orientation
	 * @param ocean ocean to place in 
	 */
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		setBowRow(row);
		setBowColumn(column);
		setHorizontal(horizontal);
		Ship[][] shipArray = ocean.getShipArray();
		if(horizontal) {
			for(int i=0 ; i<length ; i++) {
				shipArray[column + i][row] = this;
			}
		} else {
			for(int i=0 ; i<length ; i++) {
				shipArray[column][row + i] = this;
			}
		}

	}

	/**
	 * Attempts to shoot at given position. Updates ship's
	 * hit[] if necessary.
	 * 
	 * @param row target row
	 * @param column target column
	 * @return true if ship hit which hasn't already been sunk,
	 * false otherwise
	 */
	public boolean shootAt(int row, int column) {

		if(isSunk() || row<0 || row>Ocean.BOARD_SIZE
				|| column<0 || column>Ocean.BOARD_SIZE)
			return false;

		if(horizontal)
			if(row==bowRow && 
			column>=bowColumn && column<=bowColumn+length-1) {
				hit[column-bowColumn] = true;
				return true;
			} else
				return false;
		else {
			if(column==bowColumn && 
					row>=bowRow && row<=bowRow+length-1) {
				hit[row-bowRow] = true;
				return true;
			} else
				return false;
		}
	}

	/**
	 * @return true if all positions of hit[] 
	 * are true, false otherwise
	 */
	public boolean isSunk() {
		for(int i=0 ; i<getLength() ; i++) {
			if(!hit[i])
				return false;
		}
		return true;
	}

	/**
	 * @return "x" if ship is sunk, "S" otherwise
	 */
	@Override 
	public String toString() {
		if(isSunk())
			return "x";
		return "S";
	}
}
