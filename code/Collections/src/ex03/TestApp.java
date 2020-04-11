package ex03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * The Collections class implements a set of useful methods for sorting and
 * searching Collection implementations (e.g., ArrayList, LinkedList).
 * 
 * 1. Develop a concrete class (Student) comprising name, surname and grade
 * average of a student. Define a natural ordering using the Comparable
 * interface within the Student class. More specifically, Student objects have
 * to be sorted using both surname and average (in case of identical surnames).
 * 
 * 2. Test the implemented solution using Collections.sort().
 * 
 * 3. Implement an alternative sorting (by name), without modifying the Student
 * class, by making use of the Comparator interface.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		ArrayList<Student> l = new ArrayList<Student>();
		l.add(new Student("Marco", "Rossi", 28.0));
		l.add(new Student("Giulia", "Bianchi", 24.0));
		l.add(new Student("Annalisa", "Gialli", 22.0));
		l.add(new Student("Carlo", "Gialli", 24.0));
		l.add(new Student("Luca", "Gialli", 22.0));

		System.out.println("1st Ordering...");
		Collections.sort(l);
		System.out.println(l);

		System.out.println("2nd Ordering...");
		Collections.sort(l, new Comparator<Student>() {
			@Override
			public int compare(Student s0, Student s1) {
				return s0.getName().compareTo(s1.getName());
			}
		});
		System.out.println(l);
	}
}
