package ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TestApp {
	public static void main(String[] args) throws InterruptedException {
		Queue<Integer> queue;
		Producer<Integer> producer;
		Consumer<Integer> consumer;

//		/* Thread unsafe shared structure + synchronized */
//		queue = new LinkedList<Integer>();
//		producer = new ProducerSynchronized<Integer>(4, 1, queue);
//		consumer = new ConsumerSynchcronized<Integer>(queue);

//		/* Thread unsafe shared structure + synchronized + wait/notify */
//		queue = new LinkedList<Integer>();
//		producer = new ProducerSynchronizedWaitNotify<Integer>(4, 1, queue);
//		consumer = new ConsumerSynchcronizedWaitNotify<Integer>(queue);

		/* Thread safe shared structure */
		queue = new ConcurrentLinkedQueue<Integer>();
		producer = new ProducerLinkedQueue<Integer>(4, 1, queue);
		consumer = new ConsumerLinkedQueue<Integer>(queue);

		producer.start();
		consumer.start();

		Thread.sleep(100);

		producer.running = false;
		consumer.running = false;

		producer.join();
		consumer.join();
	}
}
