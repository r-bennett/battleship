package battleship;

public class Ocean {
	
	private Ship[][] shipArray;
	private int shotsFired;
	private int hits;
	private int sunk;
	private boolean gameOver;
	
	public Ocean() {
		
	}

	public void placeAllShipsRandomly() {
		
	}

	public boolean isOccupied(int row, int column) {
		return false;
	}
	
	public boolean shootAt(int row, int column) {
		return false;
	}
	
	public int getShotsFired() {
		return 0;
	}
	
	public int getHitCount() {
		return 0;
	}
	
	public int getShipsSunk() {
		return 0;
	}
	
	public boolean isGameOver() {
		return false;
	}
	
	public Ship[][] getShipArray() {
		return null;
	}
	
	@Override
	public String toString() {
		return null;
	}
}
