
public class Rect2 extends Shape {
	double width;
	double height;

	public Rect2() {
		super();
		this.width = 1;
		this.height = 1;
	}

	public Rect2(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	public Rect2(String color, boolean filled, double width, double height) {
		super(color, filled);
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getPerimeter() {
		return 2 * (width + height);
	}

}
