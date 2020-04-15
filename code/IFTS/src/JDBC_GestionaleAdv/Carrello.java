package JDBC_GestionaleAdv;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
	String nomeutente;
	int num;
	double totspesa;
	List<Prodotto> listaProdotti;

	public Carrello(String nomeutente, int num, double totspesa, ArrayList<Prodotto> listaProdotti) {
		super();
		this.nomeutente = nomeutente;
		this.num = num;
		this.totspesa = totspesa;
		this.listaProdotti = listaProdotti;
	}

	public String getNomeutente() {
		return nomeutente;
	}

	public void setNomeutente(String nomeutente) {
		this.nomeutente = nomeutente;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getTotspesa() {
		return totspesa;
	}

	public void setTotspesa(double totspesa) {
		this.totspesa = totspesa;
	}

	public List<Prodotto> getListaProdotti() {
		return listaProdotti;
	}

	public void setListaProdotti(List<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

	@Override
	public String toString() {
		return "Carrello [nomeutente=" + nomeutente + ", num=" + num + ", totspesa=" + totspesa + ", listaProdotti="
				+ listaProdotti + "]";
	}
}
