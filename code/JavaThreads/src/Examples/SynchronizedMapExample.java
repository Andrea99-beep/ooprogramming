package Examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class SMReader implements Runnable {
	Map<String, Integer> m;

	public SMReader(Map<String, Integer> m) {
		this.m = m;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(m);
		}
	}
}

class SMWriter implements Runnable {
	Map<String, Integer> m;
	boolean turn = true;
	Random rnd;

	public SMWriter(Map<String, Integer> m) {
		this.m = m;
		rnd = new Random();
	}

	@Override
	public void run() {
		while (true) {
			if (turn) {
				while (m.size() < 10) {
					int key = rnd.nextInt(1000);
					m.put(String.format("Test_%d", key), key);
				}
			}
			if (!turn) {
				ArrayList<String> keys = new ArrayList<String>(m.keySet());
				m.remove(keys.get(0));
			}
			turn = !turn;
		}
	}
}

public class SynchronizedMapExample {
	public static void main(String[] args) throws InterruptedException {
		// Map<String, Integer> m = new HashMap<String, Integer>();
		Map<String, Integer> m = Collections.synchronizedMap(new HashMap<String, Integer>());

		for (int i = 0; i < 10; i++) {
			m.put(String.format("Test_%d", i), i);
		}

		Thread t1 = new Thread(new SMReader(m));
		Thread t2 = new Thread(new SMWriter(m));
		t1.start();
		t2.start();
	}
}
