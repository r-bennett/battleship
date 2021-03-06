package battleship;

import java.util.Scanner;

/**
 * @author Bennett_Richard
 * 
 */
public class BattleshipGame {

	private static Ocean ocean;
	private static boolean playAgain = true;

	/**
	 * Runs the game, creating the ocean instance, populating with ships,
	 * printing the current ocean and accepting user input.
	 * 
	 * Also manages the end of game printing of scores and allows user to
	 * request a new game
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (playAgain) {
			ocean = new Ocean();
			ocean.placeAllShipsRandomly();
			System.out.println(ocean.toString());

			while (!ocean.isGameOver()) {
				System.out.println("Enter column number: ");
				int column = sc.nextInt();
				System.out.println("Enter row number: ");
				int row = sc.nextInt();
				ocean.shootAt(row, column);
				System.out.println();
				System.out.println(ocean.toString());
			}

			System.out.println();
			System.out.println("GAME OVER");
			System.out.println("Shots taken: " + ocean.getShotsFired());
			System.out.println();
			System.out.println("Play again? (y/n): ");
			char choice = sc.next().toLowerCase().charAt(0);
			playAgain = choice == 'y';
		}
		sc.close();
	}

}
