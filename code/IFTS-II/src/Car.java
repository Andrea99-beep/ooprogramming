
public class Car {
	String brand;
	String model;

	public Car(String brand, String model) {
		super();
		this.brand = brand;
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + "]";
	}
}
