package Examples;

import java.awt.BorderLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MovingWindow extends JFrame implements ComponentListener {
	private static final long serialVersionUID = 1L;
	private JLabel summary;

	public MovingWindow() {
		super("Moving Window");

		summary = new JLabel("");
		JPanel p1 = new JPanel(new BorderLayout());
		p1.add(summary, BorderLayout.SOUTH);

		add(p1);
		addComponentListener(this);

		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void updateLabel(int x, int y, int w, int h) {
		String text = String.format("x: %d; y: %d; w: %d; h: %d\n", x, y, w, h);
		summary.setText(text);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		updateLabel(e.getComponent().getX(), e.getComponent().getY(), e.getComponent().getWidth(),
				e.getComponent().getHeight());
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		updateLabel(e.getComponent().getX(), e.getComponent().getY(), e.getComponent().getWidth(),
				e.getComponent().getHeight());
	}

	@Override
	public void componentShown(ComponentEvent e) {
	}

	@Override
	public void componentHidden(ComponentEvent e) {
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MovingWindow ex = new MovingWindow();
				ex.setVisible(true);
			}
		});
	}
}