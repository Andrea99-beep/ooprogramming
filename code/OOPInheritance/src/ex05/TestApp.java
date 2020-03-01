package ex05;

public class TestApp {

	public static void main(String[] args) {
		ResizableCircle c = new ResizableCircle(10);
		System.out.println(c);
		c.resize(50);
		System.out.println(c);

	}

}
