package ex01;

/**
 * Create a class with a main() method throwing an Exception inside a try block.
 * Provide the Exception constructor with a String argument representing a
 * message.
 * 
 * Catch the exception within a catch block and print the contained message.
 * 
 * Add a finally block and print a message to prove that it has been executed.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		try {
			throw new Exception("Issue!");
		} catch (Exception e) {
			System.out.println("[CATCH BLOCK] -> " + e.getMessage());
		} finally {
			System.out.println("[FINALLY BLOCK]");
		}
	}

}
