package ex06;

import java.util.Scanner;

/**
 * Implement a simple Bingo (Tombola) application using two classes: Dealer and
 * Player.
 *
 * Class Dealer
 * 
 * Constructors: Dealer(): create a new Dealer object
 * 
 * Methods: int exctractNumber(): returns the next number between [1..90]
 * 
 * Class Player
 * 
 * Constructors: Player(String name): create a new player with a given name.
 * Each player holds 5 numbers (randomly assigned by the constructor).
 *
 * Methods:
 * 
 * void verifyNumber(int n): verify if the player holds the number n and
 * eventually marks it as extracted
 * 
 * boolean bingo(): returns true if all 5 numbers have been extracted
 * 
 * @author Nicola Bicocchi
 */

public class TestApp {
	public static final int MAX_PLAYERS = 4;

	public static void main(String[] args) {
		Dealer dealer = new Dealer();
		Player[] players = new Player[MAX_PLAYERS];
		boolean bingo = false;
		int round = 0;

		System.out.printf("Insert players!\n", MAX_PLAYERS);
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < MAX_PLAYERS; i++) {
			System.out.print((i + 1) + ": ");
			players[i] = new Player(scanner.next());
		}
		scanner.close();

		while (!bingo) {
			round++;
			int n = dealer.extractNumber();
			System.out.println("Dealer exctract: " + n);
			for (int i = 0; i < MAX_PLAYERS; i++) {
				players[i].verifyNumber(n);
				if (players[i].bingo()) {
					System.out.println("Wins in " + round + " extraction: " + players[i]);
					bingo = true;
				}
			}
		}
	}
}
