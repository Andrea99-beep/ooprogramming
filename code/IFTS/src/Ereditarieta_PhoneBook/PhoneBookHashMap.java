package Ereditarieta_PhoneBook;

import java.util.Collection;
import java.util.HashMap;

public class PhoneBookHashMap implements PhoneBook {
	HashMap<String, Person> m;

	public PhoneBookHashMap() {
		super();
		this.m = new HashMap<String, Person>();
	}

	@Override
	public Collection<Person> getPeople() {
		return m.values();
	}

	@Override
	public void addPerson(Person p) {
		m.put(p.getPhoneNumber(), p);
	}

	@Override
	public void removePerson(Person p) {
		m.remove(p.getPhoneNumber());
	}

	@Override
	public Person searchByName(String name) {
		for (Person p : m.values()) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public boolean modifyPerson(Person p1, Person p2) {
		if (!m.containsKey(p1.getPhoneNumber())) {
			return false;
		}
		m.remove(p1.getPhoneNumber());
		m.put(p2.getPhoneNumber(), p2);
		return true;
	}
}
