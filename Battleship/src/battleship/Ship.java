package battleship;

public abstract class Ship {
	
	public abstract int getLength();
	
	public int getBowRow() {
		return 0;
	}
	
	public int getBowColumn() {
		return 0;
	}
	
	public boolean isHorizontal() {
		return false;
	}
	
	public void setBowRow(int row) {
		
	}
	
	public void setBowColumn(int column) {
		
	}
	
	public void setHorizontal(boolean horizontal) {
		
	}
	
	public abstract String getShipType();
	
	public boolean okToPlaceShipAt(int row, int column, boolean hori, Ocean ocean) {
		return false;
	}
	
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		
	}
	
	public boolean shootAt(int row, int column) {
		return false;
	}

	public boolean isSunk() {
		return false;
	}
}
