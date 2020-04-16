package ex04;

/**
 * Create a three-level hierarchy of exceptions:
 * 
 * AException extends Exception
 * 
 * BException extends AException
 * 
 * CException extends CException
 * 
 * 
 * Create a three-level hierarchy of classes:
 * 
 * A
 * 
 * B extends A
 * 
 * C extends B
 * 
 * All three classes have a method run() throwing an exception:
 * 
 * A.run() throws AException
 * 
 * B.run() throws BException
 * 
 * C.run() throws CException
 * 
 * Test your code with the main method below.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		A item = new C();
		try {
			item.run();
		} catch (AException e) {
			e.printStackTrace();
		}

	}
}
