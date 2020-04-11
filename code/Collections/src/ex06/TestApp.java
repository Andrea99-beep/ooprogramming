package ex06;

/**
 * Develop two classes, namely ArrayPoly and ListPoly, for managing polynomials.
 * More specifically, the two classes must exhibit the same functionalities
 * (they both implement the Poly Interface) but using different mechanisms
 * internally.
 * 
 * Given a generic polynomial, c0 + c_1 * x + c_2 * x^2 + ... + c_n * x^n
 * 
 * ArrayPoly stores a polynomial using a primitive array of doubles (c0..c_n).
 * 
 * ListPoly, instead, internally stores a list of Monomio objects (see ListPoly
 * source code).
 * 
 * Both the classes must work with the main method provided below.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {

		Poly ap = new ArrayPoly(new double[] { 1, 3, 4 });
		Poly lp = new ListPoly(new double[] { 1, 3, 6, 8 });

		System.out.println("ap = " + ap.toString());
		System.out.println("lp = " + lp.toString());

		if (ap.equals(lp) && lp.equals(ap))
			System.out.println("ap == lp");
		else
			System.out.println("ap != lp");

		ap = ap.derivative();
		System.out.println("ap' = " + ap.toString());

		ap = ap.derivative();
		System.out.println("ap'' = " + ap.toString());

		lp = lp.derivative();
		System.out.println("lp' = " + lp.toString());

		lp = lp.derivative();
		System.out.println("lp'' = " + lp.toString());

	}
}
