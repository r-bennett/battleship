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
	 * @return
	 */
	public abstract int getLength();

	/**
	 * @return
	 */
	public int getBowRow() {
		return bowRow;
	}

	/**
	 * @return
	 */
	public int getBowColumn() {
		return bowColumn;
	}

	/**
	 * @return
	 */
	public boolean isHorizontal() {
		return horizontal;
	}

	/**
	 * @param row
	 */
	public void setBowRow(int row) {
		bowRow = row;
	}

	/**
	 * @param column
	 */
	public void setBowColumn(int column) {
		bowColumn = column;
	}

	/**
	 * @param horizontal
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * @return
	 */
	public abstract String getShipType();

	/**
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 * @return
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
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
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
	 * @param row
	 * @param column
	 * @return
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
	 * @return
	 */
	public boolean isSunk() {
		for(int i=0 ; i<getLength() ; i++) {
			if(!hit[i])
				return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override 
	public String toString() {
		if(isSunk())
			return "x";
		return "S";
	}
}
