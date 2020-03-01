package SortingAndSearching;

import java.util.Comparator;

/**
 * A simple comparator sorting students by average
 * 
 * @author Nicola Bicocchi
 *
 */
public class ComparatorAverage implements Comparator<Student> {
	@Override
	public int compare(Student s0, Student s1) {
		return (int) (s0.getAverage() - s1.getAverage());
	}
}
