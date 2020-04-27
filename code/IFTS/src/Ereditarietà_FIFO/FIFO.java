package Ereditarietà_FIFO;

public class FIFO extends MyAbstractQueue implements MyQueue {

	@Override
	public Person peek() {
		return tasks.get(0);
	}

	@Override
	public Person poll() {
		return tasks.remove(0);
	}
}
