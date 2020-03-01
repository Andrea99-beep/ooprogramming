
public class CircleProcessor {
	Circle[] v;

	public CircleProcessor(Circle[] v) {
		super();
		this.v = v;
	}

	public int findBiggest() {
		int max_index = 0;
		double max_area = v[0].getArea();
		for (int i = 0; i < v.length; i++) {
			if (v[i].getArea() > max_area) {
				max_area = v[i].getArea();
				max_index = i;
			}
		}
		return max_index;
	}

	public int findSmallest() {
		return 0;
	}

}
