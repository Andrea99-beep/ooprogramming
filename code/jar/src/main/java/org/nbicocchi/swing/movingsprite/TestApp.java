package org.nbicocchi.swing.movingsprite;
import javax.swing.SwingUtilities;

public class TestApp {
	public static void main(String[] args) {
		// Run GUI construction on the Event-Dispatching Thread for thread safety
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MovingSprite();
			}
		});
	}
}
