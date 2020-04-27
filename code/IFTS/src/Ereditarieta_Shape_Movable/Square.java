package Ereditarieta_Shape_Movable;

public class Square extends Shape {
	double edge;

	public Square(double x, double y, String color, int edge) {
		super(x, y, color);
		this.edge = edge;
	}

	@Override
	public double getArea() {
		return edge * edge;
	}

	@Override
	public double getPerimeter() {
		return 4 * edge;
	}

	@Override
	public String toString() {
		return "Square [edge=" + edge + ", x=" + x + ", y=" + y + ", color=" + color + "]";
	}
}
