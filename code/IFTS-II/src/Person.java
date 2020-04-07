
public class Person implements Comparable<Person> {
	String name;
	String lastName;
	double age;

	public Person(String name, String lastName, double age) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) {
		return getName().compareTo(o.getName());
	}

}
