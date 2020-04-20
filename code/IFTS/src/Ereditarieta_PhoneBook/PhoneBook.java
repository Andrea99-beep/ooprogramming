package Ereditarieta_PhoneBook;
import java.util.List;

public interface PhoneBook {
	public List<Person> getPeople();

	public void addPerson(Person p);

	public void removePerson(Person p);

	public Person searchByName(String name);

	public boolean modifyPerson(Person p1, Person p2);
}
