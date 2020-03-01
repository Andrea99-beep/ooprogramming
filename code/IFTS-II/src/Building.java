import java.util.ArrayList;

public class Building {
	String address;
	String streetNumber;
	ArrayList<Office> offices;

	public Building(String address, String streetNumber) {
		super();
		this.address = address;
		this.streetNumber = streetNumber;
		this.offices = new ArrayList<Office>();
	}

	public Building(String address, String streetNumber, ArrayList<Office> offices) {
		super();
		this.address = address;
		this.streetNumber = streetNumber;
		this.offices = offices;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public ArrayList<Office> getOffices() {
		return offices;
	}

	public void setOffices(ArrayList<Office> offices) {
		this.offices = offices;
	}

	public ArrayList<Person> searchByName(String name) {
		ArrayList<Person> tmp = new ArrayList<Person>();
		for (Office o : offices) {
			tmp.addAll(o.searchByName(name));
		}
		return tmp;
	}

	public ArrayList<Person> searchByLastName(String name) {
		ArrayList<Person> tmp = new ArrayList<Person>();
		for (Office o : offices) {
			tmp.addAll(o.searchByLastName(name));
		}
		return tmp;
	}

	@Override
	public String toString() {
		return "Building [address=" + address + ", streetNumber=" + streetNumber + ", offices=" + offices + "]";
	}

}
