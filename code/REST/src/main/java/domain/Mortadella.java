package domain;

import java.util.UUID;

public class Mortadella {
	UUID id;
	double length;
	double diameter;
	double weight;
	String quality;

	public Mortadella() {

	}

	public Mortadella(UUID id, double lenght, double diameter, double weigth, String quality) {
		this.id = id;
		this.length = lenght;
		this.diameter = diameter;
		this.weight = weigth;
		this.quality = quality;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	@Override
	public String toString() {
		return "Mortadella [id=" + id + ", lenght=" + length + ", diameter=" + diameter + ", weigth=" + weight
				+ ", quality=" + quality + "]";
	}
}
