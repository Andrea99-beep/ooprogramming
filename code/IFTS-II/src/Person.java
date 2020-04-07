
public class Person implements Comparable<Person> {
	String name;
	String lastName;
	int age;

	public Person(String name, String lastName, int age) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) {
		int ord = getName().compareTo(o.getName());
		if (ord == 0) {
			int ordc = getLastName().compareTo(o.getLastName());
			if (ordc == 0) {
				return o.getAge() - getAge();
			}
			return ordc;
		}
		return ord;
	}

}
