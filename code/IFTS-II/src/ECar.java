
public class ECar extends Car {
	int batteryCapacity;

	public ECar(String brand, String model, int batteryCapacity) {
		super(brand, model);
		this.batteryCapacity = batteryCapacity;
	}

	@Override
	public String toString() {
		return "ECar [brand=" + brand + ", model=" + model + ", batteryCapacity=" + batteryCapacity + "]";
	}
}
