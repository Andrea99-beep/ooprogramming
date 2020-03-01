package ex03;

/**
 * Use the Java wrapper types for converting a double variable into a string and
 * back. Repeat the same exercise with an int variable.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		int i;
		double d;
		String s;

		/* double <--> string conversion */
		d = 3.14;
		s = Double.toString(d);
		// or...
		s = String.valueOf(d);

		s = "3.14";
		d = Double.parseDouble(s);

		/* int <--> string conversion */
		i = 3;
		s = Integer.toString(i);
		// or...
		s = String.valueOf(i);

		s = "3";
		d = Integer.parseInt(s);
	}
}
