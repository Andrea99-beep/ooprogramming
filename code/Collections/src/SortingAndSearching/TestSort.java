package SortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;

public class TestSort {
	public static void main(String[] args) {
		ArrayList<Student> l = new ArrayList<Student>();
		l.add(new Student("Nicola", "Rossi", 28));
		l.add(new Student("Paolo", "Rossi", 25));
		l.add(new Student("Nicola", "Magri", 23));

		for (Student s : l) {
			System.out.println(s);
		}
		System.out.println();

		/*
		 * Sorting using natural ordering. Comparable must be implemented while equals()
		 * and hashcode() must be overriden in student class for defining an order
		 */
		Collections.sort(l);

		for (Student s : l) {
			System.out.println(s);
		}
		System.out.println();

		/*
		 * Sorting using a comparator
		 */
		Collections.sort(l, new ComparatorAverage());

//		Alternatively we can use this code to avoid writing 
//		an additional class (more compact version)
//
//		Collections.sort(l, new Comparator<Student>() {
//			@Override
//			public int compare(Student s0, Student s1) {
//				// generate Double objects for comparison
//				Double d0 = new Double(s0.getAverage());
//				Double d1 = new Double(s1.getAverage());
//				// actual comparison
//				return d0.compareTo(d1);
//			}	
//		});

		for (Student s : l) {
			System.out.println(s);
		}
	}

}
