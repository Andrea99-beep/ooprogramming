
/* 
 * This is a circle!
 * This is a circle again!
 */

public class Circle implements Comparable<Circle> {
	Point center;
	double r;

	public Circle(Point p, double r) {
		super();
		this.center = p;
		this.r = r;
	}

	public Circle(double x, double y, double r) {
		super();
		this.center = new Point(x, y);
		this.r = r;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point p) {
		this.center = p;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getArea() {
		return r * r * Math.PI;
	}

	public double getPerimeter() {
		return 2 * r * Math.PI;
	}

	public Line getDiameterX() {
		Point p1 = new Point(center.getX() - r, center.getY());
		Point p2 = new Point(center.getX() + r, center.getY());
		return new Line(p1, p2);
	}

	public Line getDiameterY() {
		Point p1 = new Point(center.getX(), center.getY() - r);
		Point p2 = new Point(center.getX(), center.getY() + r);
		return new Line(p1, p2);
	}

	public Rectangle getRectangle() {
		Point p1 = new Point(center.getX() - r, center.getY() - r);
		Point p2 = new Point(center.getX() + r, center.getY() + r);
		return new Rectangle(p1, p2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		long temp;
		temp = Double.doubleToLongBits(r);
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
		Circle other = (Circle) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		if (Double.doubleToLongBits(r) != Double.doubleToLongBits(other.r))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Circle [p=" + center + ", r=" + r + "]";
	}

	@Override
	public int compareTo(Circle o) {
		if (r > o.getR()) {
			return -1;
		} else if (r < o.getR()) {
			return 1;
		}
		return 0;
	}

}
