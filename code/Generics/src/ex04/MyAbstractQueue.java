package ex04;

import java.util.LinkedList;

public abstract class MyAbstractQueue<T> implements MyQueue<T> {
	LinkedList<T> elements;

	public MyAbstractQueue() {
		elements = new LinkedList<T>();
	}

	@Override
	public void add(T t) {
		elements.addFirst(t);
	}
}
