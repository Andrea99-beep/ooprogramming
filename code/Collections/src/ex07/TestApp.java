package ex07;

/**
 * Data l'interfaccia MyList (vedi sorgenti) costruire due classi MyArrayList e
 * MyLinkedList che implementano l'interfaccia data utilizzando internamente un
 * vettore di oggetti (MyArrayList) e una lista linkata (MyLinkedList). Le due
 * classi devono soddisfare il caso d'uso rappresentato nel main() seguente.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {

	public static void main(String[] args) {
		int n = 10;

		// MyList l = new MyArrayList();
		MyList l = new MyLinkedList();

		// add elements to the list
		for (int i = 0; i < n; i++) {
			l.add(i);
		}

		// print the list
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}

	}
}