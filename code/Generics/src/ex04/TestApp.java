package ex04;

/**
 * Costruire, fruttando LinkedList, una classe FIFO e una classe LIFO in grado
 * di manipolare oggetti generici. FIFO e LIFO utilizzano rispettivamente le
 * politiche Fist In First Out e Last in First Out.
 * 
 * Le due classi ritornano i loro oggetti interni attraverso due metodi: (1)
 * peek() che ritorna un elemento senza eliminarlo dalla lista e (2) poll() che
 * ritorna un elemento eliminandolo dalla lista. Gli alement sono invece
 * inseirit utilizzando il metodo add().
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] x) {
		MyQueue<Product> q1 = new LIFO<Product>();

		q1.add(new Product("Car"));
		q1.add(new Product("Ball"));
		q1.add(new Product("Spoon"));

		System.out.println(q1.peek());
		System.out.println(q1.poll());
		System.out.println(q1.poll());
		System.out.println(q1.poll());
	}

}
