package Ereditarietà_FIFO;

import java.util.LinkedList;
import java.util.List;

public abstract class MyAbstractQueue implements MyQueue {
	List<Person> tasks;
	
	public MyAbstractQueue() {
		tasks = new LinkedList<Person>();
	}

	public void add(Person t) {
		tasks.add(t);
	}
}
