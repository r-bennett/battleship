package battleship;

import java.util.Random;

public class Ocean {

	public static final int BOARD_SIZE = 10;
	private static final int ORIENT_HORIZONTAL = 0;
	private Ship[][] shipArray;
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	private boolean gameOver;
	private Random rand;
	private boolean[][] firedUpon;

	public Ocean() {
		shipArray = new Ship[BOARD_SIZE][BOARD_SIZE];
		hitCount = 0;
		shotsFired = 0;
		gameOver = false;
		shipsSunk = 0;
		firedUpon = new boolean[BOARD_SIZE][BOARD_SIZE];
		emptyShips();
		rand = new Random();
	}

	public void placeAllShipsRandomly() {	
		// try placing each ship. If not possible, start over again
		if(!place(new AircraftCarrier())) {
			emptyShips();
			placeAllShipsRandomly();
		}

		for(int i=0 ; i<2 ; i++) {
			if(!place(new Battleship())) {
				emptyShips();
				placeAllShipsRandomly();
			}
		}

		for(int i=0 ; i<2 ; i++) {
			if(!place(new Submarine())) {
				emptyShips();
				placeAllShipsRandomly();
			}
		}

		for(int i=0 ; i<2 ; i++) {
			if(!place(new Destroyer())) {
				emptyShips();
				placeAllShipsRandomly();
			}
		}

		for(int i=0 ; i<4 ; i++) {
			if(!place(new PatrolBoat())) {
				emptyShips();
				placeAllShipsRandomly();
			}
		}
	}

	private boolean place(Ship ship) {
		int orientation = rand.nextInt(2);
		int startRow = rand.nextInt(BOARD_SIZE);
		int startCol = rand.nextInt(BOARD_SIZE);
		int x = startCol;
		int y = startRow;

		// try each coordinate in turn, until you find
		// one which works, or return to where you started

		for(int j=0 ; j<2 ; j++) { // if all positions fail, try the other orientation
			do{
				if(ship.okToPlaceShipAt(x, y, orientation==ORIENT_HORIZONTAL, this)) {
					ship.placeShipAt(x, y, orientation==ORIENT_HORIZONTAL, this);
					return true;
				}
				x++;
				if(x==BOARD_SIZE) {
					x=0;
					y = (y + 1) % BOARD_SIZE;
				}
			} while (x!=startCol || y!=startRow);
			orientation = (orientation + 1) % 2;
		}

		return false;
	}

	public boolean isOccupied(int row, int column) {
		if(shipArray[row][column] == null ||
				shipArray[row][column].getClass().getSimpleName()
				.equals("EmptySea")) 
			return false;
		return true;
	}

	public boolean shootAt(int row, int column) {
		if(row<0 || row>=BOARD_SIZE
				|| column<0 || column>=BOARD_SIZE)
			return false;

		shotsFired++;
		firedUpon[row][column] = true;

		if(!isOccupied(row, column))
			return false;

		Ship target = shipArray[row][column];
		if(target.isSunk())
			return false;

		if(target.shootAt(row, column)) {
			hitCount++;
			if(target.isSunk()) {
				shipsSunk++;
				if(shipsSunk==11)
					gameOver = true;
			}
			return true;
		}
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
				if(firedUpon[i][j])
					out += shipArray[i][j].toString() + "\t";
				else
					out += ".\t";
			}
			out += "\n";
		}
		return out;
	}
	
	public String toFullString() {
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

	private void emptyShips() {
		for(int i=0 ; i<BOARD_SIZE ; i++) {
			for(int j=0 ; j<BOARD_SIZE ; j++) {
				shipArray[i][j] = new EmptySea();
			}
		}
	}
}
