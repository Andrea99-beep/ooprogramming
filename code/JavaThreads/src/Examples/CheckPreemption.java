package Examples;

public class CheckPreemption implements Runnable {
	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName());

			/* yield() release CPU control */
			// Thread.yield();
		}
	}

	public static void main(String argv[]) {
		CheckPreemption c = new CheckPreemption();
		new Thread(c, "To be").start();
		new Thread(c, "Not to be").start();
	}
}
