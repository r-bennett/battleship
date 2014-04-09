package battleship;

public abstract class Ship {

	protected int length;
	private int bowRow;
	private int bowColumn;
	private boolean horizontal;
	protected boolean[] hit;

	public abstract int getLength();

	public int getBowRow() {
		return bowRow;
	}

	public int getBowColumn() {
		return bowColumn;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public void setBowRow(int row) {
		bowRow = row;
	}

	public void setBowColumn(int column) {
		bowColumn = column;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	public abstract String getShipType();

	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		System.out.println(this.getShipType());
		if(horizontal) {
			// check in bounds
			if(column<0 || column>Ocean.BOARD_SIZE-length 
					|| row<0 || row>=Ocean.BOARD_SIZE) {
				System.out.println("out of bounds at " + column + ", " + row);
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
						System.out.println("found conflicting ship at " + i + ", " + j);
						return false;
					}
				}
			}
		} else {
			// check in bounds
			if(column<0 || column>=Ocean.BOARD_SIZE
					|| row<0 || row>Ocean.BOARD_SIZE-length) {
				System.out.println("out of bounds at " + column + ", " + row);
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
						System.out.println("found conflicting ship at " + i + ", " + j);
						return false;
					}
				}
			}
		}
		System.out.println("placing " + this.getShipType() + " at " + column + ", " + row);
		return true;
	}

	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		setBowRow(row);
		setBowColumn(column);
		setHorizontal(horizontal);
		Ship[][] shipArray = ocean.getShipArray();
		if(horizontal) {
			for(int i=0 ; i<length ; i++) {
				shipArray[row][column + i] = this;
			}
		} else {
			for(int i=0 ; i<length ; i++) {
				shipArray[row + i][column] = this;
			}
		}

	}

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

	public boolean isSunk() {
		for(int i=0 ; i<getLength() ; i++) {
			if(!hit[i])
				return false;
		}
		return true;
	}

	@Override 
	public String toString() {
		if(isSunk())
			return "x";
		return "S";
	}
}
