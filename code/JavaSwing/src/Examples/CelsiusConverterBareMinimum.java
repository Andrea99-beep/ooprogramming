package Examples;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class CelsiusConverterBareMinimum extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton CFButton, FCButton;
	private JTextField fahrenheitTF, celsiusTF;

	public CelsiusConverterBareMinimum() {
		super("Celsius Converter");
		celsiusTF = new JTextField("000");
		fahrenheitTF = new JTextField("032");
		CFButton = new JButton("°C->°F");
		FCButton = new JButton("°F->°C");

		JPanel p1 = new JPanel();
		p1.add(celsiusTF);
		p1.add(new JLabel("°C"));
		p1.add(fahrenheitTF);
		p1.add(new JLabel("°F"));
		p1.add(CFButton);
		p1.add(FCButton);

		/* JFrame methods called */
		setContentPane(p1);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(350, 75);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CelsiusConverterBareMinimum();
	}
}
