package Ereditarietà_FIFO;

public class Person implements Comparable<Person> {
	String name;
	String lastname;
	String phone;

	public Person(String name, String lastname, String phone) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", lastname=" + lastname + ", phone=" + phone + "]";
	}

	@Override
	public int compareTo(Person o) {
		return getLastname().compareTo(o.getLastname());
	}

}
