package Ereditarieta_Motorbike;

public class TestApp {
	public static void main(String[] args) {
		Motorbike m1 = new Motorbike(true, "Black", "Yamaha", 50);
		Motorbike m2 = new MotorbikeSold(true, "Black", "Yamaha", 50, "ABCD", 130);
		System.out.println(m1);
		System.out.println(m2);
	}
}
