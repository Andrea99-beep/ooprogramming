package Ereditarietà_FIFO;

public interface MyQueue {
	public void add(Task t);
	public Task peek();
	public Task poll();
}
