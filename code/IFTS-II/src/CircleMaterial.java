
public class CircleMaterial extends Circle {
	String material;

	public CircleMaterial(Point p, double r, String color, String material) {
		super(p, r, color);
		this.material = material;
	}

	@Override
	public String toString() {
		return "CircleMaterial [material=" + material + ", color=" + color + ", center=" + center + ", r=" + r + "]";
	}
}
