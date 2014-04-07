package battleship;

public class Ocean {
	
	private Ship[][] shipArray;
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
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
		return shotsFired;
	}
	
	public int getHitCount() {
		return hitCount;
	}
	
	public int getShipsSunk() {
		return shipsSunk;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	public Ship[][] getShipArray() {
		return shipArray;
	}
	
	@Override
	public String toString() {
		String out = " \t";
		for(int i=0 ; i<shipArray[0].length ; i++) {
			out += i + "\t";
		}
		out += "\n";
 		for(int i=0 ; i<shipArray.length ; i++) {
 			out += i + "\t";
			for(int j=0 ; j<shipArray[0].length ; j++) {
				out += shipArray[i][j].toString() + "\t";
			}
			out += "\n";
		}
 		return out;
	}
}
