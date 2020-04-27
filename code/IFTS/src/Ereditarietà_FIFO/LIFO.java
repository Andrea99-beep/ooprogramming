package Ereditarietà_FIFO;

public class LIFO extends MyAbstractQueue implements MyQueue {

	@Override
	public Person peek() {
		return tasks.get(tasks.size()-1);
	}

	@Override
	public Person poll() {
		return tasks.remove(tasks.size()-1);
	}
}
