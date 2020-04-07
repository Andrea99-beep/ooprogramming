import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App {
	public static void main(String[] args) {

		ArrayList<Circle> l1 = new ArrayList<Circle>();
		l1.add(new Circle(0, 0, 7, "white"));
		l1.add(new Circle(5, 5, 10, "black"));
		l1.add(new Circle(3, 3, 1, "orange"));

		for (Circle c : l1) {
			System.out.println(c + " " + c.getArea());
		}

		Collections.sort(l1);

		Collections.sort(l1, new Comparator<Circle>() {
			@Override
			public int compare(Circle c0, Circle c1) {
				// generate Double objects for comparison
				Double d0 = new Double(c0.getArea());
				Double d1 = new Double(c1.getArea());
				// actual comparison
				return d0.compareTo(d1);
			}
		});

		for (Circle c : l1) {
			System.out.println(c + " " + c.getArea());
		}

	}
}
