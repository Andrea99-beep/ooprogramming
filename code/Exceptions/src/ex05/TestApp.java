package ex05;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a class StringChecker capable of verifying if a String, passed as
 * parameter to its method check(), is an alternating sequence of letters and
 * numbers (for example, a0b3h4z1r4).
 * 
 * check() uses ParseException for notifying the caller about eventual errors.
 * 
 * Test your code with the main method below.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("rrr6t8f0d0e");
		l.add("r5r6t8f0d0e");
		l.add("r2r6t8f0d00");
		l.add("z1z0t8f1d7d");

		StringChecker sc = new StringChecker();
		for (String s : l) {
			try {
				System.out.printf("Checking %s ", s);
				sc.check(s);
				System.out.println("[PASS]");
			} catch (ParseException e) {
				System.out.println("[FAIL]");
			}
		}
	}

}
