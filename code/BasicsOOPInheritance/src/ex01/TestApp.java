package ex01;

/**
 * Aprire la cartella doc/ all’interno del progetto Eclipse corrente. Scrivere
 * il codice Java relativo alla documentazione (index.html) delle classi
 * contenute nel package ex01. In particolare, le due classi da implementare
 * (Motorbike, MotorbikeSold) devono funzionare con il main sottostante.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		Motorbike m1 = new Motorbike("Yamaha", "FZ1");
		MotorbikeSold m2 = new MotorbikeSold("Guzzi", "Stelvio", "AA123BB");

		System.out.println(m1);
		System.out.println(m2);

		m2.setSpeed(200);

		System.out.println(m1);
		System.out.println(m2);
	}
}
