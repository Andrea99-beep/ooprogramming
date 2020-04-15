package Ereditarieta_Shape;

import java.util.ArrayList;

public class TestApp {
	public static void main(String[] args) {
		ArrayList<Shape> l = new ArrayList<Shape>();
		l.add(new Circle(0, 0, "Black", 3));
		l.add(new Square(0, 0, "Yellow", 5));

		for (Shape s : l) {
			System.out.println(s);
			System.out.println("area=" + s.getArea());
			System.out.println("perimeter=" + s.getPerimeter());
		}
	}
}
