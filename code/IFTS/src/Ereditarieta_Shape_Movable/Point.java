package Ereditarieta_Shape_Movable;

public class Point extends Shape {

	public Point(double x, double y, String color) {
		super(x, y, color);
	}

	@Override
	public double getArea() {
		return 0;
	}

	@Override
	public double getPerimeter() {
		return 0;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", color=" + color + "]";
	}
}
