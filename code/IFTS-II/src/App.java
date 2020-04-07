import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App {
	public static void main(String[] args) {

		ArrayList<Person> l1 = new ArrayList<Person>();
		l1.add(new Person("Mario", "Rossi", 28));
		l1.add(new Person("Luca", "Bianchi", 34));
		l1.add(new Person("Marco", "Verdi", 35));

		Collections.sort(l1);
		System.out.println(l1);

		Collections.sort(l1, new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				return p0.getLastName().compareTo(p1.getLastName());
			}
		});
		System.out.println(l1);

	}
}
