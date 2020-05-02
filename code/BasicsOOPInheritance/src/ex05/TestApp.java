package ex05;

/**
 * Implementare le classi rappresentate nel diagramma UML extra/ex05.jpg e
 * verificarne il buon funzionamento attraverso il metodo main() sottostante.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		ResizableCircle c = new ResizableCircle(10);
		System.out.println(c);
		c.resize(75);
		System.out.println(c);
	}
}
