package ex03;

public class Test {
	public void f() throws fException {
		try {
			g();
		} catch (gException e) {
			throw new fException();
		}
	}

	public void g() throws gException {
		throw new gException();
	}

}
