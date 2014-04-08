package battleship;

import java.util.Random;

public class Ocean {

	private static final int BOARD_SIZE = 10;
	private static final int ORIENT_HORIZONTAL = 0;
	private static final int ORIENT_VERTICAL = 1;
	private Ship[][] shipArray;
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	private boolean gameOver;
	private Random rand;
	private boolean[][] firedUpon;

	public Ocean() {
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
		int length = ship.getLength();
		int orientation = rand.nextInt(2);
		int startRow = rand.nextInt(BOARD_SIZE);
		int startCol = rand.nextInt(BOARD_SIZE);
		int x = startRow;
		int y = startCol;
		
		// try each coordinate in turn, until you find
		// one which works, or return to where you started
		
		for(int j=0 ; j<2 ; j++) { // if all positions fail, try the other orientation
			do{
				if(orientation==ORIENT_HORIZONTAL) {
					if(!(x > BOARD_SIZE - length)) {
						if(isValid(x, y, length, orientation)){
							for(int i=0 ; i<length ; i++) {
								shipArray[x+i][y] = ship;
							}
							return true;
						}
					}
				} else {
					if(!(y > BOARD_SIZE - length)) {
						if(isValid(x, y, length, orientation)) {
							for(int i=0 ; i<length ; i++) {
								shipArray[x][y+i] = ship;
							}
							return true;
						}
					}
				}
				x++;
				if(x == BOARD_SIZE) {
					// start on next row
					x = 0;
					y = (y+1) % BOARD_SIZE;
				}
			} while (x!=startRow || y!=startCol);
			orientation = (orientation + 1) % 2;
		}

		return false;
	}

	private boolean isValid(int x, int y, int length, int orientation) {
		// check all surrounding squares for ships
		if(orientation==ORIENT_HORIZONTAL) {
			for(int i=x-1 ; i<=x+length  ; i++) {
				if(i<0 || i>=BOARD_SIZE) 
					continue;
				for(int j=y-1 ; j<=y+1 ; j++) {
					if(j<0 || j>=BOARD_SIZE)
						continue;
					if(isOccupied(i,j))
						return false;
				}
			}
			return true;
		}

		if(orientation==ORIENT_VERTICAL) {
			for(int i=x-1 ; i<=x+1 ; i++) {
				if(i<0 || i>=BOARD_SIZE) 
					continue;
				for(int j=y-1 ; j<=y+length ; y++) {
					if(j<0 || j>=BOARD_SIZE)
						continue;
					if(isOccupied(i,j))
						return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean isOccupied(int row, int column) {
		if(shipArray[row][column].getClass().getSimpleName()
				.equals("EmptySea")) 
			return false;
		return true;
	}

	public boolean shootAt(int row, int column) {
		firedUpon[row][column] = true;
		// some other stuff here ...........................................................................................
		return shipArray[row][column].shootAt(row, column);
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

	private void emptyShips() {
		for(int i=0 ; i<BOARD_SIZE ; i++) {
			for(int j=0 ; j<BOARD_SIZE ; j++) {
				shipArray[i][j] = new EmptySea();
			}
		}
	}
}
