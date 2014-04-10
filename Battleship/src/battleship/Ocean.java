package battleship;

import java.util.Random;

/**
 * @author Bennett_Richard
 *
 */
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

	/**
	 * Initialises all fields. Also adds an instance of
	 * EmptySea to all positions of shipArray[][]
	 */
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

	/**
	 * 	Attempts to place the correct number of each type
	 * of ship, beginning with the largest. If the current layout means there 
	 * is no valid position for the ship, then the board is wiped and
	 * the process restarted.
	 * 
	 */
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

	/**
	 * Generates a random bow coordinate and orientation, 
	 * and attempts to place ship there. If not possible, 
	 * cycles through all possible positions and orientations.
	 * Method returns once ship is placed or all permutations
	 * have been tried.
	 * 
	 * @param ship the ship to be placed
	 * @return true if the ship was placed successfully,
	 * false if there are no valid positions for the ship
	 */
	private boolean place(Ship ship) {
		int orientation = rand.nextInt(2);
		int startRow = rand.nextInt(BOARD_SIZE);
		int startCol = rand.nextInt(BOARD_SIZE);
		int col = startCol;
		int row = startRow;

		// try each coordinate in turn, until you find
		// one which works, or return to where you started

		for(int j=0 ; j<2 ; j++) { // if all positions fail, try the other orientation
			do{
				if(ship.okToPlaceShipAt(row, col, orientation==ORIENT_HORIZONTAL, this)) {
					ship.placeShipAt(row, col, orientation==ORIENT_HORIZONTAL, this);
					return true;
				}
				col++;
				if(col==BOARD_SIZE) {
					col=0;
					row = (row + 1) % BOARD_SIZE;
				}
			} while (col!=startCol || row!=startRow);
			orientation = (orientation + 1) % 2;
		}

		return false;
	}

	/**
	 * Checks if a given position is occupied
	 * 
	 * @param row the row to check
	 * @param column the column to check
	 * @return true if a non-EmptySea ship is in the position,
	 * false if the position is EmptySea or null
	 */
	public boolean isOccupied(int row, int column) {
		if(shipArray[column][row] == null ||
				shipArray[column][row].getClass().getSimpleName()
				.equals("EmptySea")) 
			return false;
		return true;
	}

	/**
	 * Shoots at the given position. Updates the firedUpon[][]
	 * array, and if there is an unsunk ship at the position calls
	 * the ship's shootAt() method. Updates shipsSunk, hitCount and gameOver 
	 * fields where necessary.
	 * 
	 * @param row target row
	 * @param column target column
	 * @return true if an unsunk ship is hit, false otherwise
	 */
	public boolean shootAt(int row, int column) {
		if(row<0 || row>=BOARD_SIZE
				|| column<0 || column>=BOARD_SIZE)
			return false;

		shotsFired++;
		firedUpon[column][row] = true;

		if(!isOccupied(row, column))
			return false;

		Ship target = shipArray[column][row];
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

	/**
	 * @return shotsFired
	 */
	public int getShotsFired() {
		return shotsFired;
	}

	/**
	 * @return hitCount
	 */
	public int getHitCount() {
		return hitCount;
	}

	/**
	 * @return shipsSunk
	 */
	public int getShipsSunk() {
		return shipsSunk;
	}

	/**
	 * @return gameOver
	 */
	public boolean isGameOver() {
		return gameOver;
	}

	/**
	 * @return shipArray
	 */
	public Ship[][] getShipArray() {
		return shipArray;
	}

	/**
	 * @return string representing the player's board.
	 * Has digits 0 to 9 along top row and down first column
	 * for coordinates, and all columns separated with a single
	 * space. Unfired on positions show '.', fired and missed
	 * show '-', fired and hit show 'S', and fired and sunk show 'x'
	 */
	@Override
	public String toString() {
		String out = "  ";
		for(int i=0 ; i<BOARD_SIZE ; i++) {
			out += i + " ";
		}
		out += "\n";
		for(int i=0 ; i<BOARD_SIZE ; i++) {
			out += i + " ";
			for(int j=0 ; j<BOARD_SIZE ; j++) {
				if(firedUpon[j][i])
					out += shipArray[j][i].toString() + " ";
				else
					out += ". ";
			}
			out += "\n";
		}
		return out;
	}
	
	/**
	 * Fills shipArray with instances of EmptySea 
	 */
	private void emptyShips() {
		for(int i=0 ; i<BOARD_SIZE ; i++) {
			for(int j=0 ; j<BOARD_SIZE ; j++) {
				shipArray[i][j] = new EmptySea();
			}
		}
	}
}
