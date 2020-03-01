package ex06;

import java.util.Random;

public class Player {
	public static final int MAX_NUMBER = 5;

	String name;
	int[] numbers;
	boolean[] numbers_used;

	/**
	 * Constructs a player with a given name and 5 unique numbers associated
	 * 
	 * @param name the name of the player
	 */
	public Player(String name) {
		this.name = name;
		this.numbers = new int[MAX_NUMBER];
		this.numbers_used = new boolean[MAX_NUMBER];

		while (!verifyNumbers()) {
			fillNumbers();
		}
	}

	/**
	 * Returns true if the 5 numbers are not unique (there are duplicates)
	 * 
	 * @return
	 */
	private boolean verifyNumbers() {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if ((i != j) && (numbers[i] == numbers[j]))
					return false;
			}
		}
		return true;
	}

	/**
	 * Fill the 5 numbers with random values (duplicates allowed)
	 */
	private void fillNumbers() {
		Random rnd = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rnd.nextInt(90) + 1;
			numbers_used[i] = false;
		}
	}

	/**
	 * Receives a number from the dealer and mark it as extracted
	 * 
	 * @param n the number that have to be marked as extracted
	 */
	public void verifyNumber(int n) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == n) {
				numbers_used[i] = true;
				break;
			}
		}
	}

	/**
	 * Returns true is the player made bingo!
	 * 
	 * @return true is the player made bingo!
	 */
	public boolean bingo() {
		for (int i = 0; i < numbers_used.length; i++) {
			if (numbers_used[i] == false) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		String str = name + " ";
		for (int i = 0; i < MAX_NUMBER; i++) {
			if (numbers_used[i] == true) {
				str += numbers[i] + "[*]-";
			} else {
				str += numbers[i] + "[ ]-";
			}
		}
		return str;
	}
}
