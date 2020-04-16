package ex02;

/**
 * Create a custom exception MyException using the extends keyword.
 * 
 * Test MyException using the main() method below.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		try {
			throw new MyException("mmmhhh....");
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}
}
