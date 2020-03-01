package Examples;

import java.util.Random;

class Worker implements Runnable {

	@Override
	public void run() {
		Random rnd = new Random();
		System.out.println(Thread.currentThread().getName() + " starting...");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println("Interrupted!");
		}
		System.out.println(Thread.currentThread().getName() + " ending...");
	}
}

public class JoinExample {
	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		while (true) {
			Thread t = new Thread(new Worker(), String.format("worker_%d", i++));
			t.start();
			t.join();
		}
	}

}
