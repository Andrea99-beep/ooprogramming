package Collections;

import java.util.Comparator;

import Basics.Person;

public class AlternativeSorter implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
