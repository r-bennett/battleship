package battleship;

public class BattleshipGame {
	
	private static Ocean ocean;
	private static boolean gameOver;
	
	static {
		gameOver = false;
	}

	public static void main(String[] args) {
		ocean = new Ocean();
		ocean.placeAllShipsRandomly();
		System.out.println(ocean.toString());
		
		while(!gameOver) {
			// do stuff
		}
	}

}
