import java.util.Comparator;

public class ComparatorRadius implements Comparator<Circle> {

	@Override
	public int compare(Circle o1, Circle o2) {
		if (o1.getCenter().getY() < o2.getCenter().getY()) {
			return 1;
		} else if (o1.getCenter().getY() > o2.getCenter().getY()) {
			return -1;
		}
		return 0;
	}

}
