package Ereditarieta_PhoneBook;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookArrayList implements PhoneBook {
	ArrayList<Person> l;

	public PhoneBookArrayList() {
		super();
		this.l = new ArrayList<Person>();
	}

	@Override
	public List<Person> getPeople() {
		return l;
	}

	@Override
	public void addPerson(Person p) {
		l.add(p);
	}

	@Override
	public void removePerson(Person p) {
		l.remove(p);
	}

	@Override
	public Person searchByName(String name) {
		for (Person p : l) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public boolean modifyPerson(Person p1, Person p2) {
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).equals(p1)) {
				l.set(i, p2);
				return true;
			}
		}
		return false;
	}
}
