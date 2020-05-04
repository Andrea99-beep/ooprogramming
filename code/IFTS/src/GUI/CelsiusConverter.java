package GUI;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CelsiusConverter extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JTextField tfCelsius;
	JTextField tfFahrneit;
	JButton btConvert;

	public CelsiusConverter() throws HeadlessException {
		super("Celsius Converter");

		tfCelsius = new JTextField("0000");
		tfFahrneit = new JTextField("0032");
		btConvert = new JButton("Convert!");
		btConvert.addActionListener(this);

		JPanel p1 = new JPanel(new GridLayout(1, 5));
		p1.add(tfCelsius);
		p1.add(new JLabel("°C"));
		p1.add(tfFahrneit);
		p1.add(new JLabel("°F"));
		p1.add(btConvert);

		setContentPane(p1);
		setSize(300, 75);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double tc = Double.parseDouble(tfCelsius.getText());
		double tf = (tc * 1.8) + 32;
		tfFahrneit.setText(String.format("%f", tf));
	}

	public static void main(String[] args) {
		new CelsiusConverter();
	}
}
