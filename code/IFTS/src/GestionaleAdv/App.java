package GestionaleAdv;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class App extends JFrame implements ActionListener {
	List<Utente> utenti;
	int currentSelection;

	JTextField tfUsername;
	JTextField tfPassword;
	JTextField tfName;
	JTextField tfCode;
	JTextArea taCart;
	JButton btnPrev;
	JButton btnNext;

	public App(List<Utente> utenti) {
		this.utenti = utenti;
		this.currentSelection = 0;

		tfUsername = new JTextField();
		tfPassword = new JTextField();
		tfName = new JTextField();
		tfCode = new JTextField();
		taCart = new JTextArea();
		btnPrev = new JButton("Previous");
		btnPrev.addActionListener(this);
		btnNext = new JButton("Next");
		btnNext.addActionListener(this);

		JPanel pMain = new JPanel(new BorderLayout());

		JPanel pUser = new JPanel(new GridLayout(4, 2));
		pUser.add(new JLabel("Username"));
		pUser.add(new JLabel("Password"));
		pUser.add(tfUsername);
		pUser.add(tfPassword);
		pUser.add(new JLabel("Name"));
		pUser.add(new JLabel("Tax Code"));
		pUser.add(tfName);
		pUser.add(tfCode);

		JPanel pButtons = new JPanel(new GridLayout(1, 2));
		pButtons.add(btnPrev);
		pButtons.add(btnNext);

		pMain.add(pUser, BorderLayout.PAGE_START);
		pMain.add(taCart, BorderLayout.CENTER);
		pMain.add(pButtons, BorderLayout.PAGE_END);
		getContentPane().add(pMain);

		setSize(800, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		update();
	}

	public void update() {
		Utente u = utenti.get(currentSelection);
		tfUsername.setText(u.getUsername());
		tfPassword.setText(u.getPwd());
		tfName.setText(u.getNome());
		tfCode.setText(u.getCodfisc());

		taCart.setText("");
		for (Carrello c : u.getListaCarrello()) {
			taCart.append(c.toString() + "\n");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPrev) {
			currentSelection = Math.max(0, currentSelection - 1);
		}
		if (e.getSource() == btnNext) {
			currentSelection = Math.min(utenti.size() - 1, currentSelection + 1);
		}
		update();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		List<Utente> utenti = new ArrayList<Utente>();

		/* database connection */
		DBManager db = new DBManager();

		/* utility variables */
		String query;
		ResultSet rs;

		/* load users */
		query = "SELECT * FROM ecommerce.utente";
		rs = db.executeQuery(query);
		while (rs.next()) {
			utenti.add(new Utente(rs.getString("username"), rs.getString("codfisc"), rs.getString("pwd"),
					rs.getString("nome"), null));
		}
		rs.close();

		/* load carts */
		for (Utente u : utenti) {
			List<Carrello> lcarrello = new ArrayList<Carrello>();
			query = "SELECT scelta.username, scelta.num, SUM(di.qta * prodotto.prezzo) AS TotaleSpesa\r\n"
					+ "FROM utente, scelta, di, prodotto\r\n" + "WHERE utente.username = scelta.username\r\n"
					+ "AND scelta.num = di.num\r\n" + "AND scelta.username = di.username\r\n"
					+ "AND prodotto.idprodotto = di.codProd\r\n" + "AND utente.username='" + u.getUsername() + "'\r\n"
					+ "group by utente.nome, scelta.username, scelta.num";
			rs = db.executeQuery(query);
			while (rs.next()) {
				lcarrello.add(
						new Carrello(rs.getString("username"), rs.getInt("num"), rs.getDouble("TotaleSpesa"), null));
			}
			u.setListaCarrello(lcarrello);
		}
		rs.close();

		/* load products */
		for (Utente u : utenti) {
			for (Carrello c : u.getListaCarrello()) {
				List<Prodotto> lprodotto = new ArrayList<Prodotto>();
				query = "SELECT prodotto.idprodotto, prodotto.descrizione, prodotto.prezzo, di.qta\r\n"
						+ " from prodotto, di\r\n" + " where prodotto.idprodotto=di.codProd\r\n" + " and di.username='"
						+ u.getUsername() + "'\r\n" + " and di.num=" + c.getNum() + ";";
				rs = db.executeQuery(query);
				while (rs.next()) {
					lprodotto.add(new Prodotto(rs.getString("descrizione"), rs.getString("idprodotto"),
							rs.getDouble("prezzo"), rs.getInt("qta")));
				}
				c.setListaProdotti(lprodotto);
			}
		}
		rs.close();

		if (db != null) {
			db.close();
		}

		App app = new App(utenti);
	}
}
