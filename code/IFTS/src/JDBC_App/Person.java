package JDBC_App;

public class Person {
	String name;
	String lastname;
	String yearBirth;
	String phone;

	public Person(String name, String lastname, String yearBirth, String phone) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.yearBirth = yearBirth;
		this.phone = phone;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the yearBirth
	 */
	public String getYearBirth() {
		return yearBirth;
	}

	/**
	 * @param yearBirth the yearBirth to set
	 */
	public void setYearBirth(String yearBirth) {
		this.yearBirth = yearBirth;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", lastname=" + lastname + ", yearBirth=" + yearBirth + ", phone=" + phone
				+ "]";
	}
}
