package ex04;

/**
 * Implementare le classi rappresentate nel diagramma UML extra/ex04.jpg e
 * verificarne il buon funzionamento attraverso il metodo main() sottostante.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		MovableRectangle r = new MovableRectangle(0, 10, 20, 0, 1, 1);
		System.out.println(r);

		r.moveRight();
		r.moveUp();
		System.out.println(r);
	}
}
