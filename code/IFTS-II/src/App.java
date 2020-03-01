import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		Building building = new Building("Viale Santità", "17/A");
		Office o;
		ArrayList<Person> p;

		o = new Office("I", "I-A");
		p = o.getPeople();
		p.add(new Person("Luca", "Rossi"));
		p.add(new Person("Lucia", "Verdi"));
		p.add(new Person("Luca", "Neri"));
		p.add(new Person("Marco", "Bianchi"));
		building.getOffices().add(o);

		o = new Office("I", "I-B");
		p = o.getPeople();
		p.add(new Person("Lucia", "Rossi"));
		p.add(new Person("John", "Verdi"));
		p.add(new Person("Giovanni", "Bianchi"));
		building.getOffices().add(o);

		o = new Office("II", "I-K");
		building.getOffices().add(o);

		o = new Office("II", "I-J");
		p = o.getPeople();
		p.add(new Person("Pietro", "Gialli"));
		p.add(new Person("Lucia", "Neri"));
		p.add(new Person("Luca", "White"));
		building.getOffices().add(o);

		System.out.println(building);

		System.out.println(building.searchByName("Luca"));
	}
}
