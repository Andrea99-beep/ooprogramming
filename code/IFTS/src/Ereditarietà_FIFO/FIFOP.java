package Ereditarietà_FIFO;

import java.util.Collections;

public class FIFOP extends MyAbstractQueue implements MyQueue {
	
	@Override
	public void add(Person t) {
		tasks.add(t);
		Collections.sort(tasks);
	}

	@Override
	public Person peek() {
		return tasks.get(tasks.size()-1);
	}

	@Override
	public Person poll() {
		return tasks.remove(tasks.size()-1);
	}

}
