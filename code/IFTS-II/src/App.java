import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class App {
	public static void main(String[] args) {
		List<Line> l1 = new ArrayList<Line>();

		l1.add(new Line(new Point(0, 0), new Point(1, 1)));
		l1.add(new Line(new Point(0, 0), new Point(2, 2)));
		l1.add(new Line(new Point(0, 0), new Point(3, 3)));
		l1.add(new Line(new Point(0, 0), new Point(4, 4)));

		ListIterator<Line> i = l1.listIterator();
		while (i.hasNext()) {
			Line l = i.next();
			if (l.getLenght() > 100) {
				i.remove();
			}
		}

		System.out.println(l1);
	}
}
