
public class Rectangle {
	double x1, y1, x2, y2;

	public Rectangle(Point p1, Point p2) {
		super();
		this.x1 = p1.getX();
		this.y1 = p1.getY();
		this.x2 = p2.getX();
		this.y2 = p2.getY();
	}

	public Point getP1() {
		return new Point(x1, y1);
	}

	public void setP1(Point p1) {
		this.x1 = p1.getX();
		this.y1 = p1.getY();
	}

	public Point getP2() {
		return new Point(x2, y2);
	}

	public void setP2(Point p2) {
		this.x2 = p2.getX();
		this.y2 = p2.getY();
	}

	public double getArea() {
		double l1 = Math.abs(x1 - x2);
		double l2 = Math.abs(y1 - y2);
		return l1 * l2;
	}

	public double getPerimeter() {
		double l1 = Math.abs(x1 - x2);
		double l2 = Math.abs(y1 - y2);
		return 2 * (l1 + l2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(x2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (Double.doubleToLongBits(x1) != Double.doubleToLongBits(other.x1))
			return false;
		if (Double.doubleToLongBits(x2) != Double.doubleToLongBits(other.x2))
			return false;
		if (Double.doubleToLongBits(y1) != Double.doubleToLongBits(other.y1))
			return false;
		if (Double.doubleToLongBits(y2) != Double.doubleToLongBits(other.y2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rectangle [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + "]";
	}
}
