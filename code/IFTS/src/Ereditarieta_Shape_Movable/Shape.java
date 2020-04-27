package Ereditarieta_Shape_Movable;

public abstract class Shape implements Computable, Movable {
	double x;
	double y;
	String color;

	public Shape(double x, double y, String color) {
		this.x = x;
		this.y = y;
		this.color = color;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void moveUp(double d) {
		y += d;
	}

	@Override
	public void moveDown(double d) {
		y -= d;
	}

	@Override
	public void moveLeft(double d) {
		x -= d;
	}

	@Override
	public void moveRight(double d) {
		x += d;
	}
}
