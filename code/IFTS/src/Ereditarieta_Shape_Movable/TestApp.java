package Ereditarieta_Shape_Movable;

import java.util.ArrayList;

public class TestApp {
	public static void main(String[] args) {
		ArrayList<Shape> l = new ArrayList<Shape>();
		l.add(new Circle(0, 0, "Pink", 3));
		l.add(new Square(0, 0, "Blue", 5));
		l.add(new Point(0, 0, "Black"));

		l.get(1).moveDown(10);
		l.get(2).moveLeft(5);

		for (Shape s : l) {
			System.out.println(s);
			System.out.println("area=" + s.getArea());
			System.out.println("perimeter=" + s.getPerimeter());
		}
	}
}
