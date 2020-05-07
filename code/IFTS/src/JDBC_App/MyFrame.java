package JDBC_App;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MyFrame extends JFrame implements ActionListener {
	JTextField tfname;
	JTextField tflastname;
	JTextField tfyearBirth;
	JTextField tfphone;

	JButton btPrev;
	JButton btNext;
	JButton btInsert;
	JButton btRemove;

	DBManager db;
	List<Person> people;
	int selectedItem = 0;

	public MyFrame(String title) throws HeadlessException {
		super(title);

		tfname = new JTextField("");
		tflastname = new JTextField("");
		tfyearBirth = new JTextField("");
		tfphone = new JTextField("");
		tfname.addActionListener(this);
		tflastname.addActionListener(this);
		tfyearBirth.addActionListener(this);
		tfphone.addActionListener(this);

		btPrev = new JButton("Prev");
		btNext = new JButton("Next");
		btInsert = new JButton("Insert");
		btRemove = new JButton("Remove");
		btPrev.addActionListener(this);
		btNext.addActionListener(this);
		btInsert.addActionListener(this);
		btRemove.addActionListener(this);

		JPanel p1 = new JPanel(new GridLayout(2, 2));
		p1.add(tfname);
		p1.add(tflastname);
		p1.add(tfyearBirth);
		p1.add(tfphone);

		JPanel p2 = new JPanel(new GridLayout(2, 2));
		p2.add(btPrev);
		p2.add(btNext);
		p2.add(btInsert);
		p2.add(btRemove);

		JPanel p3 = new JPanel(new BorderLayout());
		p3.add(p1, BorderLayout.CENTER);
		p3.add(p2, BorderLayout.PAGE_END);

		setContentPane(p3);
		setSize(600, 150);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

		try {
			initData();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "JDBC Driver Missing");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "JDBC Connection Failed");
		}
		updateUI();
	}

	void initData() throws ClassNotFoundException, SQLException {
		selectedItem = 0;
		people = new ArrayList<Person>();
		people.add(new Person("Mario", "Rossi", "1990", "347327495"));
		people.add(new Person("Luca", "Verdi", "1992", "263427624"));
		people.add(new Person("Marco", "Gialli", "1980", "123174966"));
		people.add(new Person("Giovanni", "Neri", "1984", "798731213"));

		try {
			db = new DBManager(DBManager.JDBCDriverMySQL, DBManager.JDBCURLMySQL);
			db.executeQuery("SELECT * FROM person LIMIT 1");
		} catch (SQLException e) {
			db.executeUpdate("DROP TABLE IF EXISTS person");
			db.executeUpdate("CREATE TABLE person (" + "id VARCHAR(50) PRIMARY KEY, " + "name VARCHAR(50), "
					+ "lastname VARCHAR(50), " + "yearbirth VARCHAR(50), " + "phone VARCHAR(50))");

			/* Examples for easier debug */
			db.executeUpdate(
					"INSERT INTO person (id, name, lastname, yearbirth, phone) VALUES ('214bb0db-aa52-48be-b052-cd30f730ae79', 'Mario', 'Neri', '1980', '3474')");
			db.executeUpdate(
					"INSERT INTO person (id, name, lastname, yearbirth, phone) VALUES ('03e9e721-f241-4539-9cc7-baecd8b3a931', 'Gianni', 'Bianchi', '1990', '1234')");
			db.executeUpdate(
					"INSERT INTO person (id, name, lastname, yearbirth, phone) VALUES ('e1f0dcb0-181b-4463-97d7-edcfed736ae1', 'Luisa', 'Verdi', '2000', '5678')");
		}
	}

	void updateUI() {
		try {
			Person p = people.get(selectedItem);
			tfname.setText(p.getName());
			tflastname.setText(p.getLastname());
			tfyearBirth.setText(p.getYearBirth());
			tfphone.setText(p.getPhone());
		} catch (java.lang.IndexOutOfBoundsException e) {
			tfname.setText("");
			tflastname.setText("");
			tfyearBirth.setText("");
			tfphone.setText("");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		if (e.getSource() == btNext) {
			selectedItem = Math.min(people.size() - 1, selectedItem + 1);
		}
		if (e.getSource() == btPrev) {
			selectedItem = Math.max(0, selectedItem - 1);
		}
		if (e.getSource() == btInsert) {
			String[] data = JOptionPane.showInputDialog(this, "Insert a person (name;lastname;year birth;phone)")
					.split(";");
			people.add(new Person(data[0], data[1], data[2], data[3]));
			selectedItem = people.size() - 1;
		}
		if (e.getSource() == btRemove) {
			if (people.isEmpty())
				return;
			people.remove(selectedItem);
			if (selectedItem == people.size()) {
				selectedItem -= 1;
			}
		}
		updateUI();
	}

}
