package battleship;

import java.util.Scanner;

public class BattleshipGame {
	
	private static Ocean ocean;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ocean = new Ocean();
		ocean.placeAllShipsRandomly();
		System.out.println(ocean.toString());
		
		while(!ocean.isGameOver()) {
			int column = sc.nextInt();
			int row = sc.nextInt();
			ocean.shootAt(row, column);
			System.out.println();
			System.out.println(ocean.toString());
		}
		sc.close();
	}

}
