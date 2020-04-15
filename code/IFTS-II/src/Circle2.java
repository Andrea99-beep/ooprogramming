
public class Circle2 extends Shape {
	double radius;

	public Circle2() {
		super();
		this.radius = 1;
	}

	public Circle2(double radius) {
		super();
		this.radius = radius;
	}

	public Circle2(String color, boolean filled, double radius) {
		super(color, filled);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
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

}
