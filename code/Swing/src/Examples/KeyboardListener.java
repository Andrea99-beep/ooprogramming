package Examples;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class KeyboardListener extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L;
	ArrayList<Integer> lastChars;
	JPanel panel;

	public KeyboardListener() {
		lastChars = new ArrayList<Integer>(Arrays.asList(0, 0, 0));
		panel = new JPanel();

		Container cp = getContentPane();
		cp.add(panel);
		cp.setFocusable(true);
		cp.addKeyListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Testing Key Listener");
		setSize(300, 200);
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		char keyChar = e.getKeyChar();
		System.out.println("keyPressed: VK Code is " + keyCode + ", Key char is " + keyChar);

		// update panel's color
		lastChars.add(0, keyCode);
		lastChars.remove(3);
		panel.setBackground(new Color(lastChars.get(0), lastChars.get(1), lastChars.get(2)));
		repaint();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new KeyboardListener();
			}
		});
	}
}
