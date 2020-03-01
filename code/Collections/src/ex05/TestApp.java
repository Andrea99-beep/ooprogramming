package ex05;

/**
 * The provided PhoneBook Interface defines the functionalities of a basic phone
 * book. Provide two different implementations of the given interface working
 * with the use below. (a) The first using internally Arraylist, the second (b)
 * using internally HashMap.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		PhoneBook pb = new PhoneBookHash();
		// PhoneBook pb = new PhoneBookArray();
		pb.addPerson(new Person("Nicola", "Bicocchi", "34567"));
		pb.addPerson(new Person("Marco", "Rizzo", "45243"));
		pb.addPerson(new Person("Luisa", "Poppi", "24564"));

		System.out.println(pb.searchByName("Marco"));
		System.out.println(pb.searchByLastname("Poppi"));

		// do not exist!
		System.out.println(pb.searchByNumber("1111"));

		// delete an element!
		pb.deleteByNumber("24564");
		System.out.println(pb.searchByLastname("Poppi"));
	}
}
