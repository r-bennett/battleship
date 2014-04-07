package battleship;

public class BattleshipGame {
	
	private static Ocean ocean;

	public static void main(String[] args) {
		ocean = new Ocean();
		ocean.placeAllShipsRandomly();
		System.out.println(ocean.toString());
		
		while(!ocean.isGameOver()) {
			// do stuff
		}
	}

}
