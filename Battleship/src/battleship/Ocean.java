package battleship;

public class Ocean {
	
	private static final int BOARD_SIZE = 10;
	private Ship[][] shipArray;
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	private boolean gameOver;
	
	public Ocean() {
		hitCount = 0;
		shotsFired = 0;
		gameOver = false;
		shipsSunk = 0;
		for(int i=0 ; i<BOARD_SIZE ; i++) {
			for(int j=0 ; j<BOARD_SIZE ; j++) {
				shipArray[i][j] = new EmptySea();
			}
		}
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
		for(int i=0 ; i<BOARD_SIZE ; i++) {
			out += i + "\t";
		}
		out += "\n";
 		for(int i=0 ; i<BOARD_SIZE ; i++) {
 			out += i + "\t";
			for(int j=0 ; j<BOARD_SIZE ; j++) {
				out += shipArray[i][j].toString() + "\t";
			}
			out += "\n";
		}
 		return out;
	}
}
