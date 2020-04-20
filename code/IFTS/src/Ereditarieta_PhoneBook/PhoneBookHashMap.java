package Ereditarieta_PhoneBook;
import java.util.HashMap;
import java.util.List;

public class PhoneBookHashMap implements PhoneBook {
	HashMap<String, Person> m;

	public PhoneBookHashMap() {
		super();
		this.m = new HashMap<String, Person>();
	}

	@Override
	public List<Person> getPeople() {

	}

	@Override
	public void addPerson(Person p) {

	}

	@Override
	public void removePerson(Person p) {

	}

	@Override
	public Person searchByName(String name) {

	}

	@Override
	public boolean modifyPerson(Person p1, Person p2) {

	}
}
