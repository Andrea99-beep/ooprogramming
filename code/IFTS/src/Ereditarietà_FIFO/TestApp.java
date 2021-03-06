package Ereditarietà_FIFO;

/**
 * Costruire, fruttando LinkedList, una classe FIFO, una classe LIFO, e una
 * classe FIFOP. Le tre classi rappresentano tre tipi di code che implementano
 * algoritmi differenti al loro interno. Tutte e tre le classi, devono ospitare
 * sequenze di azioni da campiere (Task) caratterizzati da un ID (String) e da
 * una priorità (int).
 * 
 * FIFO utilizza Fist In First Out
 * 
 * LIFO utilizza Last in First Out
 * 
 * FIFOP ordina i task in base alla loro priorità
 * 
 * Le tre classi, come le code ufficiali Java (vedi PriorityQueue), ritornano i
 * loro oggetti interni attraverso due metodi: (1) peek() che ritorna un
 * elemento senza eliminarlo dalla lista e (2) poll() che ritorna un elemento
 * eliminandolo dalla lista.
 * 
 * Per una corretta implementazione, il concetto generico di coda va definito
 * all'interno di un'interfaccia. L'interfaccia, viene parzialmente implementata
 * in una classe astratta le cui figlie (FIFO, FIFOP, LIFO) completano
 * l'implementazione.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] x) {
		MyQueue q1 = new FIFOP();

		q1.add(new Person("Nicola", "Bianchi", "334234"));
		q1.add(new Person("Marco", "Zucchi", "135434"));
		q1.add(new Person("Pino", "Lelli", "765634"));

		System.out.println(q1.poll());
		System.out.println(q1.poll());
		System.out.println(q1.poll());
	}

}
