package ex03;

/**
 * Implementare le classi rappresentate nel diagramma UML extra/ex03.jpg e
 * verificarne il buon funzionamento attraverso il metodo main() sottostante.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {

	public static void main(String[] args) {
		Shape[] v = new Shape[4];
		v[0] = new Circle("Red", true, 2);
		v[1] = new Circle(3);
		v[2] = new Rectangle(2, 3);
		v[3] = new Square(3);

		for (Shape s : v) {
			System.out.println(s);

			if (s instanceof Rectangle) {
				Rectangle r = (Rectangle) s;
				System.out.println(r.getWidth());
				System.out.println(r.getHeigth());

			}
		}
	}
}
