package JDBC_GestionaleAdv;

public class Prodotto {
	String descr;
	String codProd;
	double prezzo;
	int qta;

	public Prodotto(String descr, String codProd, double prezzo, int qta) {
		super();
		this.descr = descr;
		this.codProd = codProd;
		this.prezzo = prezzo;
		this.qta = qta;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getCodProd() {
		return codProd;
	}

	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getQta() {
		return qta;
	}

	public void setQta(int qta) {
		this.qta = qta;
	}

	@Override
	public String toString() {
		return "Prodotto [descr=" + descr + ", codProd=" + codProd + ", prezzo=" + prezzo + ", qta=" + qta + "]";
	}
}
