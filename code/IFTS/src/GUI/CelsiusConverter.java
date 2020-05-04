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
	JButton btCF;
	JButton btFC;

	public CelsiusConverter() throws HeadlessException {
		super("Celsius Converter");

		tfCelsius = new JTextField("0.0");
		tfFahrneit = new JTextField("32.0");
		btCF = new JButton("C->F");
		btCF.addActionListener(this);
		btFC = new JButton("F->C");
		btFC.addActionListener(this);

		JPanel p1 = new JPanel(new GridLayout(1, 6));
		p1.add(tfCelsius);
		p1.add(new JLabel("°C"));
		p1.add(tfFahrneit);
		p1.add(new JLabel("°F"));
		p1.add(btCF);
		p1.add(btFC);

		setContentPane(p1);
		setSize(400, 75);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btCF) {
			double tc = Double.parseDouble(tfCelsius.getText());
			double tf = (tc * 1.8) + 32;
			tfFahrneit.setText(String.format("%.1f", tf));
		}

		if (e.getSource() == btFC) {
			double tf = Double.parseDouble(tfFahrneit.getText());
			double tc = (tf - 32) / 1.8;
			tfCelsius.setText(String.format("%.1f", tc));
		}
	}

	public static void main(String[] args) {
		new CelsiusConverter();
	}
}
