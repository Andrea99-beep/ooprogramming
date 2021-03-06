package DataEntry;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Utils.DBManager;

public class DataEntry_v3_Online_Model extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	public static String[] qualities = { "High", "Average", "Low", "Shitty" };

	DBManager db;
	DataEntry_v3_Model_Updateable model;

	JTextField tfLenght;
	JTextField tfDiameter;
	JTextField tfWeight;
	JComboBox<String> cbQuality;

	JButton btnPrev;
	JButton btnNext;
	JButton btnInsert;
	JButton btnRemove;

	public DataEntry_v3_Online_Model() throws SQLException {
		super("Mortadelle Manager");

		try {
			// db = new DBManager(DBManager.JDBCDriverSQLite, DBManager.JDBCURLSQLite);

			db = new DBManager(DBManager.JDBCDriverMySQL, DBManager.JDBCURLMySQL, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			db.executeQuery("SELECT * FROM mortadella LIMIT 1");
		} catch (SQLException e) {
			db.executeUpdate("DROP TABLE IF EXISTS mortadella");
			db.executeUpdate("CREATE TABLE mortadella (" + "id VARCHAR(50) PRIMARY KEY, " + "lenght REAL, "
					+ "diameter REAL, " + "weight REAL, " + "quality VARCHAR(50))");

			/* Examples for easier debug */
			db.executeUpdate(
					"INSERT INTO mortadella (id, lenght, diameter, weight, quality) VALUES ('214bb0db-aa52-48be-b052-cd30f730ae79', 30.2, 30.0, 2.6, 'High')");
			db.executeUpdate(
					"INSERT INTO mortadella (id, lenght, diameter, weight, quality) VALUES ('03e9e721-f241-4539-9cc7-baecd8b3a931', 40.3, 35.5, 2.2, 'Low')");
			db.executeUpdate(
					"INSERT INTO mortadella (id, lenght, diameter, weight, quality) VALUES ('e1f0dcb0-181b-4463-97d7-edcfed736ae1', 35.1, 28.2, 4.3, 'High')");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		model = new DataEntry_v3_Model_Updateable(db);

		tfLenght = new JTextField();
		tfDiameter = new JTextField();
		tfWeight = new JTextField();
		cbQuality = new JComboBox<String>(qualities);

		btnPrev = new JButton("Prev");
		btnNext = new JButton("Next");
		btnInsert = new JButton("Insert");
		btnRemove = new JButton("Remove");

		tfLenght.addActionListener(this);
		tfDiameter.addActionListener(this);
		tfWeight.addActionListener(this);
		cbQuality.addActionListener(this);

		btnPrev.addActionListener(this);
		btnNext.addActionListener(this);
		btnInsert.addActionListener(this);
		btnRemove.addActionListener(this);

		JPanel p1 = new JPanel(new GridLayout(4, 2));
		p1.add(new JLabel("Lenght"));
		p1.add(tfLenght);

		p1.add(new JLabel("Diameter"));
		p1.add(tfDiameter);

		p1.add(new JLabel("Weight"));
		p1.add(tfWeight);

		p1.add(new JLabel("Quality"));
		p1.add(cbQuality);

		JPanel p2 = new JPanel(new GridLayout(2, 2));
		p2.add(btnPrev);
		p2.add(btnNext);
		p2.add(btnInsert);
		p2.add(btnRemove);

		setLayout(new BorderLayout());
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);

		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		showItem();
	}

	public void showItem() {
		try {
			tfLenght.setText(Double.toString(model.getSelectedItem().getLenght()));
			tfDiameter.setText(Double.toString(model.getSelectedItem().getDiameter()));
			tfWeight.setText(Double.toString(model.getSelectedItem().getWeigth()));
			cbQuality.setSelectedItem(model.getSelectedItem().getQuality());
		} catch (IndexOutOfBoundsException e) {
			tfLenght.setText("");
			tfDiameter.setText("");
			tfWeight.setText("");
		} catch (NullPointerException e) {
			tfLenght.setText("");
			tfDiameter.setText("");
			tfWeight.setText("");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			model.next();
			showItem();
		}

		else if (e.getSource() == btnPrev) {
			model.previous();
			showItem();
		}

		else if (e.getSource() == btnInsert) {
			String[] v = JOptionPane.showInputDialog(this, "Insert Mortadella (lenght;diameter;weight;quality)")
					.split(";");
			model.insert(Double.parseDouble(v[0]), Double.parseDouble(v[1]), Double.parseDouble(v[2]), v[3]);
			showItem();
		}

		else if (e.getSource() == btnRemove) {
			model.remove();
			showItem();
		}

		else if (e.getSource() == tfLenght) {
			model.setLenght(Double.parseDouble(tfLenght.getText()));
		}

		else if (e.getSource() == tfDiameter) {
			model.setDiameter(Double.parseDouble(tfDiameter.getText()));
		}

		else if (e.getSource() == tfWeight) {
			model.setWeight(Double.parseDouble(tfWeight.getText()));
		}

		else if (e.getSource() == cbQuality) {
			model.setQuality(cbQuality.getSelectedItem().toString());
		}
	}

	public static void main(String[] args) throws SQLException {
		new DataEntry_v3_Online_Model();
	}
}
