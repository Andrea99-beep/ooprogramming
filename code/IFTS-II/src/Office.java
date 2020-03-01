import java.util.ArrayList;

public class Office {
	String floor;
	String code;
	ArrayList<Person> people;

	public Office(String floor, String code, ArrayList<Person> people) {
		super();
		this.floor = floor;
		this.code = code;
		this.people = people;
	}

	public Office(String floor, String code) {
		super();
		this.floor = floor;
		this.code = code;
		this.people = new ArrayList<Person>();
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}

	public ArrayList<Person> searchByName(String name) {
		ArrayList<Person> tmp = new ArrayList<Person>();
		for (Person p : people) {
			if (p.getName().equals(name)) {
				tmp.add(p);
			}
		}
		return tmp;
	}

	public ArrayList<Person> searchByLastName(String name) {
		ArrayList<Person> tmp = new ArrayList<Person>();
		for (Person p : people) {
			if (p.getLastName().equals(name)) {
				tmp.add(p);
			}
		}
		return tmp;
	}

	@Override
	public String toString() {
		return "Office [floor=" + floor + ", code=" + code + ", people=" + people + "]";
	}
}
