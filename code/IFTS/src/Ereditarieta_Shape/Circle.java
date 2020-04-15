package Ereditarieta_Shape;

public class Circle extends Shape {
	double radius;

	public Circle(double x, double y, String color, int radius) {
		super(x, y, color);
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return radius * radius * Math.PI;
	}

	@Override
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}

	@Override
	public String toString() {
		return "Square [edge=" + radius + ", x=" + x + ", y=" + y + ", color=" + color + "]";
	}
}
