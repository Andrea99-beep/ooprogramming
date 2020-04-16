package ex04;

public class B extends A {
	public void run() throws BException {
		throw new BException();
	}

}
