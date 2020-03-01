package ex06;

import java.util.Random;

public class Dealer {
	Random rnd;
	boolean[] numbers_used;

	public Dealer() {
		rnd = new Random();
		numbers_used = new boolean[90];
	}

	/**
	 * Returns the next number [1..90]
	 * 
	 * @return the next number [1..90]
	 */
	public int extractNumber() {
		int tmp;
		do {
			tmp = rnd.nextInt(90) + 1;
		} while (numbers_used[tmp - 1]);
		numbers_used[tmp - 1] = true;
		return tmp;
	}

}
