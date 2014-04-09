package battleship;

import java.util.Scanner;

public class BattleshipGame {

	private static Ocean ocean;
	private static boolean playAgain = true;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(playAgain) {
			ocean = new Ocean();
			ocean.placeAllShipsRandomly();
			System.out.println(ocean.toString());

			while(!ocean.isGameOver()) {
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
			playAgain = choice=='y';
		}
		sc.close();
	}

}
