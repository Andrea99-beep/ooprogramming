package Ereditarieta_Motorbike;

public class MotorbikeSold extends Motorbike {
	String licencePlate;
	double maxSpeed;

	public MotorbikeSold(boolean antitheft, String color, String model, double speed, String licencePlate,
			double maxSpeed) {
		super(antitheft, color, model, speed);
		this.licencePlate = licencePlate;
		this.maxSpeed = maxSpeed;
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "MotorbikeSold [licencePlate=" + licencePlate + ", maxSpeed=" + maxSpeed + ", antitheft=" + antitheft
				+ ", color=" + color + ", model=" + model + ", speed=" + speed + "]";
	}

}
