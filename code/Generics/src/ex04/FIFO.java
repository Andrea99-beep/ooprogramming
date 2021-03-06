package ex04;

public class FIFO<T> extends MyAbstractQueue<T> implements MyQueue<T> {

	@Override
	public T peek() {
		return elements.getLast();
	}

	@Override
	public T poll() {
		return elements.removeLast();
	}
}
