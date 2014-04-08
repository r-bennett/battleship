package battleship;

public abstract class Ship {
	
	protected int length = 0;
	private int bowRow;
	private int bowColumn;
	private boolean horizontal;
	private boolean sunk;
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
	
	public boolean okToPlaceShipAt(int row, int column, boolean hori, Ocean ocean) {
		return false;
	}
	
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		
	}
	
	public boolean shootAt(int row, int column) {
		return false;
	}

	public boolean isSunk() {
		return sunk;
	}
	
	@Override 
	public String toString() {
		if(isSunk())
			return "x";
		return "S";
	}
}
