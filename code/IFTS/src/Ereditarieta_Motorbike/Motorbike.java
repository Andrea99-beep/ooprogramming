package Ereditarieta_Motorbike;

public class Motorbike {
	boolean antitheft;
	String color;
	String model;
	double speed;

	public Motorbike(boolean antitheft, String color, String model, double speed) {
		super();
		this.antitheft = antitheft;
		this.color = color;
		this.model = model;
		this.speed = speed;
	}

	public boolean isAntitheft() {
		return antitheft;
	}

	public void setAntitheft(boolean antitheft) {
		this.antitheft = antitheft;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Motorbike [antitheft=" + antitheft + ", color=" + color + ", model=" + model + ", speed=" + speed + "]";
	}

}
