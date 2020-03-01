package ProducerConsumer;

import java.util.ArrayList;
import java.util.List;

class ProducerSynchronized extends Thread {
	public static final int LIMIT = 2;
	public boolean running = true;
	private int count = 0;
	List<Integer> l;

	public ProducerSynchronized(List<Integer> l) {
		this.l = l;
	}

	@Override
	public void run() {
		while (running) {
			synchronized (l) {
				if (l.size() < LIMIT) {
					l.add(count);
					System.out.println("Producer " + Thread.currentThread().getName() + " pushed " + count++);
				}
			}
		}
	}
}

class ConsumerSynchcronized extends Thread {
	public boolean running = true;
	List<Integer> l;

	public ConsumerSynchcronized(List<Integer> l) {
		this.l = l;
	}

	@Override
	public void run() {
		while (running) {
			synchronized (l) {
				if (l.size() > 0) {
					System.out.println("Consumer " + Thread.currentThread().getName() + " removed " + l.remove(0));
				}
			}
		}
	}
}

public class PCSynchronized {
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Integer> l = new ArrayList<Integer>();

		ProducerSynchronized p = new ProducerSynchronized(l);
		ConsumerSynchcronized c = new ConsumerSynchcronized(l);

		p.start();
		c.start();

		Thread.sleep(100);

		c.running = false;
		p.running = false;

		p.join();
		c.join();
	}
}
