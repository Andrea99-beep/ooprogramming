package Examples;

public class SleepExample {
	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		while (true) {
			Thread t = new Thread(new Worker(), String.format("worker_%d", i++));
			t.start();

			/* wait 100ms */
			Thread.sleep(100);

			/* interrupt the child thread */
			t.interrupt();

			t.join();
		}
	}

}
