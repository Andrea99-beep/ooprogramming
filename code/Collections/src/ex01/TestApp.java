package ex01;

/**
 * Costruire una classe per calcolare media e mediana di un gruppo di elementi
 * interi aderendo al caso d’uso sottostante.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] x) {
		MyStats s = new MyStats();
		s.add(5);
		s.add(10);
		s.add(70);

		System.out.printf("media=%.2f\n", s.getMedia());
		System.out.printf("mediana=%.2f\n", s.getMediana());

		for (int i : s.elems()) {
			System.out.println(i);
		}
	}

}
