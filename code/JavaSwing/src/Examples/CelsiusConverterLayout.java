package Examples;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class CelsiusConverterLayout extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton CFButton;
	private JButton FCButton;
	private JTextField fahrenheitTF;
	private JTextField celsiusTF;

	public CelsiusConverterLayout() {
		super("Celsius Converter");
		celsiusTF = new JTextField("0");
		fahrenheitTF = new JTextField("32");
		CFButton = new JButton("°C->°F");
		FCButton = new JButton("°F->°C");

		JPanel p1 = new JPanel(new GridLayout(2, 2));
		p1.add(celsiusTF);
		p1.add(new JLabel("°C"));
		p1.add(fahrenheitTF);
		p1.add(new JLabel("°F"));
		
		JPanel p2 = new JPanel(new GridLayout(1, 2));
		p2.add(CFButton);
		p2.add(FCButton);

		JPanel p3 = new JPanel(new BorderLayout());
		p3.add(p1, BorderLayout.NORTH);	
		p3.add(p2, BorderLayout.SOUTH);

		/* JFrame methods called */
		setContentPane(p3);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(200, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CelsiusConverterLayout();
	}
}


