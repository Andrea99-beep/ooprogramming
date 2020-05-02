package Examples;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UnresponsiveUIwThread extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private boolean running = false;
	private int countValue = 1;

	private JTextField tfCount;
	private JButton btnStart, btnStop;

	public UnresponsiveUIwThread() {
		super("Counter");
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		p1.add(new JLabel("Counter"));

		tfCount = new JTextField("" + countValue, 10);
		tfCount.setEditable(false);
		p1.add(tfCount);

		btnStart = new JButton("Start Counting");
		btnStart.addActionListener(this);
		p1.add(btnStart);

		btnStop = new JButton("Stop Counting");
		btnStop.addActionListener(this);
		p1.add(btnStop);

		add(p1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 120);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStop) {
			running = true;
		} else if (e.getSource() == btnStart) {
			running = false;

			/*
			 * Use a separate thread for executing the updateCounter() method
			 */
			Thread t = new Thread() {
				@Override
				public void run() {
					updateCounter();
				}
			};
			t.start();   

			/*
			 * Execute the updateCounter() method in main thread.
			 * The alternative above (execution inside thread must be commented)
			 */
			//updateCounter();
		}
	}
	
	void updateCounter() {
		for (int i = 0; i < 1000000; i++) {
			if (running) break;
			tfCount.setText(Integer.valueOf(countValue).toString());
			countValue++;
		}
		
	}

	public static void main(String[] args) {
		new UnresponsiveUIwThread();
	}
}