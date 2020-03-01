package Examples;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Counter extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton btnInc;
	private JButton btnDec;
	private JLabel label;

	public Counter() {
		super("Counter!");
		btnInc = new JButton("Increment");
		btnInc.addActionListener(this);
		btnDec = new JButton("Decrement");
		btnDec.addActionListener(this);
		label = new JLabel("0");

		JPanel p1 = new JPanel(new GridLayout(1, 3));
		p1.add(btnInc);
		p1.add(btnDec);
		p1.add(label);

		add(p1);
		setSize(300, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInc) {
			int n = Integer.parseInt(label.getText()) + 1;
			label.setText(Integer.toString(n));
		} else if (e.getSource() == btnDec) {
			int n = Integer.parseInt(label.getText()) - 1;
			label.setText(Integer.toString(n));
		}
	}

	public static void main(String[] args) {
		new Counter();
	}

}
