package Examples;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class CelsiusConverterBasic extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton CFButton;
	private JButton FCButton;
	private JTextField fahrenheitTF;
	private JTextField celsiusTF;

	public CelsiusConverterBasic() {
		super("Celsius Converter");
		celsiusTF = new JTextField("000");
		fahrenheitTF = new JTextField("032");

		CFButton = new JButton("°C->°F");
		CFButton.addActionListener(this);
		FCButton = new JButton("°F->°C");
		FCButton.addActionListener(this);

		JPanel p1 = new JPanel(new GridLayout(3, 2));
		p1.add(celsiusTF);
		p1.add(new JLabel("°C"));
		p1.add(fahrenheitTF);
		p1.add(new JLabel("°F"));
		p1.add(CFButton);
		p1.add(FCButton);

		setContentPane(p1);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(500, 150);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == CFButton) {
			double tc = Double.parseDouble(celsiusTF.getText());
			double tf = tc * 1.8 + 32;
			fahrenheitTF.setText(Double.toString(tf));
		} else if (e.getSource() == FCButton) {
			double tf = Double.parseDouble(fahrenheitTF.getText());
			double tc = (tf - 32) / 1.8;
			celsiusTF.setText(Double.toString(tc));
		} else {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new CelsiusConverterBasic();
	}

}
