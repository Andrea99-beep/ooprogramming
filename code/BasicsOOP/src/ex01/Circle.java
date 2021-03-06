package ex01;

/**
 * Write a Java class representing a Circle (x, y, r). Inside the class, define
 * a static attribute representing PI. Create two objects, c1 and c2, of class
 * Circle.
 * 
 * Verify what happens when PI is accessed as a class attribute or, instead, as
 * an instance attribute (using c1 or c2). What happens when an instance (e.g.,
 * c1) modifies the value of PI? What happens when PI is defined final?
 * 
 * @author Nicola Bicocchi
 *
 */

public class Circle {
	public static double PI = 3.14;
	private double x;
	private double y;
	private double r;

	public Circle(double x, double y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public static void main(String[] args) {
		// Circle c1 = new Circle(2, 2, 4);
		// Circle c2 = new Circle(2, 2, 4);
		//
		// System.out.println(c1.PI);
		// System.out.println(c2.PI);
		//
		// Circle.PI = 4;
		// System.out.println(c1.PI);
		// System.out.println(c2.PI);
		//
		// c1.PI = 3;
		// System.out.println(c1.PI);
		// System.out.println(c2.PI);
	}
}
