package Ereditarieta;

public class ECar extends Car {
	protected double battery;

	public ECar(String brand, String model, double battery) {
		super(brand, model);
		this.battery = battery;
	}

	public double getBattery() {
		return battery;
	}

	public void setBattery(double battery) {
		this.battery = battery;
	}

	public void hello() {
		System.out.println("This is a Ecar!");
	}

	@Override
	public String toString() {
		return "ECar [battery=" + battery + ", brand=" + brand + ", model=" + model + "]";
	}
}
