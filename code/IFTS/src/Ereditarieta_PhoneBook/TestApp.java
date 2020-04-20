package Ereditarieta_PhoneBook;

public class TestApp {
	public static void main(String[] args) {
		PhoneBook pb = new PhoneBookArrayList();
		pb.addPerson(new Person("Nicoletta", "Bicocchi", "4464"));
		pb.addPerson(new Person("Luca", "Bicocchi", "3323"));
		pb.addPerson(new Person("Nicola", "Bianchi", "7766"));
		pb.addPerson(new Person("Marco", "Neri", "7789"));

		/* Remove one person */
		pb.removePerson(new Person("Luca", "Bicocchi", "3323"));

		/* Update one person */
		pb.modifyPerson(new Person("Marco", "Neri", "7789"), new Person("Marco", "Neri", "1234"));

		/* Show all people */
		System.out.println(pb.getPeople());

		/* Show the first person named Marco */
		System.out.println(pb.searchByName("Marco"));
	}
}
