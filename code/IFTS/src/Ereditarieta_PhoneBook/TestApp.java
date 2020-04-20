package Ereditarieta_PhoneBook;
import java.util.HashMap;

public class TestApp {
	public static void main(String[] args) {
		HashMap<String, Person> m = new HashMap<String, Person>();
		m.put("4464", new Person("Nicoletta", "Bicocchi", "4464"));
		m.put("1234", new Person("Marco", "Biagi", "1234"));
		m.put("5678", new Person("Giuseppe", "Garibaldi", "5678"));
		m.put("8888", new Person("Roberto", "Baggio", "8888"));

		System.out.println(m);
		System.out.println(m.containsKey("1234"));
		System.out.println(m.containsValue(new Person("Roberto", "Baggio", "8888")));
		System.out.println(m.get("5678"));
		m.remove("8888");
		System.out.println(m.containsKey("8888"));
		m.clear();
		System.out.println(m);

		/*
		 * PhoneBook pb = new PhoneBookArrayList(); pb.addPerson(new Person("Nicoletta",
		 * "Bicocchi", "4464")); pb.addPerson(new Person("Luca", "Bicocchi", "3323"));
		 * pb.addPerson(new Person("Nicola", "Bianchi", "7789")); pb.addPerson(new
		 * Person("Marco", "Neri", "7789"));
		 * 
		 * pb.removePerson(new Person("Luca", "Bicocchi", "3323"));
		 * 
		 * pb.modifyPerson(new Person("Marco", "Neri", "7789"), new Person("Gianluca",
		 * "Vialli", "1234"));
		 * 
		 * System.out.println(pb.getPeople());
		 * 
		 * System.out.println(pb.searchByName("Gianluca"));
		 */

	}
}
