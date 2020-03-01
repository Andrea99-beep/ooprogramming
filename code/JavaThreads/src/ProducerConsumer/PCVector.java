package ProducerConsumer;

import java.util.List;
import java.util.Vector;

class ProducerVector extends Thread {
	public static final int LIMIT = 4;
	public boolean running = true;
	private List<Integer> l;
	private int count = 0;

	public ProducerVector(List<Integer> l) {
		this.l = l;
	}

	@Override
	public void run() {
		while (running) {
			if (l.size() < LIMIT) {
				l.add(Integer.valueOf(count));
				System.out.println("Producer " + Thread.currentThread().getName() + " pushed " + count++);
			}
		}
	}
}

class ConsumerVector extends Thread {
	public boolean running = true;
	private List<Integer> l;

	public ConsumerVector(List<Integer> l) {
		this.l = l;
	}

	@Override
	public void run() {
		while (running) {
			if (l.size() > 0) {
				System.out.println("Comsumer " + Thread.currentThread().getName() + " consumed " + l.remove(0));
			}
		}
	}
}

public class PCVector {
	public static void main(String[] args) throws InterruptedException {
		// unsafe!
		// List<Integer> l = new LinkedList();

		// safe using Vector
		List<Integer> l = new Vector<Integer>();

		ProducerVector p = new ProducerVector(l);
		ConsumerVector c = new ConsumerVector(l);

		p.start();
		c.start();

		Thread.sleep(100);

		c.running = false;
		p.running = false;

		p.join();
		c.join();
	}
}