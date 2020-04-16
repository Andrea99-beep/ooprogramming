package ex03;

/**
 * Partial delegation consist in intercepting one exception eventually generated
 * within a try block and, in the catch block, throwing another exception.
 * 
 * Create a class Test comprising two methods, f() and g().
 * 
 * In g(), throw an exception gException.
 * 
 * In f(), call g(), catch gException and throw a new exception fException.
 * 
 * Test your code with the main method below.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		Test t = new Test();
		try {
			t.f();
		} catch (fException e) {
			e.printStackTrace();
		}
	}
}
