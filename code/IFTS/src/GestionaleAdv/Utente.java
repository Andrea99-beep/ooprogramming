package GestionaleAdv;

import java.util.List;

public class Utente {
	String username;
	String pwd;
	String nome;
	String codfisc;
	List<Carrello> listaCarrello;

	public Utente(String username, String pwd, String nome, String codfisc, List<Carrello> listaCarrello) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.nome = nome;
		this.codfisc = codfisc;
		this.listaCarrello = listaCarrello;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodfisc() {
		return codfisc;
	}

	public void setCodfisc(String codfisc) {
		this.codfisc = codfisc;
	}

	public List<Carrello> getListaCarrello() {
		return listaCarrello;
	}

	public void setListaCarrello(List<Carrello> listaCarrello) {
		this.listaCarrello = listaCarrello;
	}

	@Override
	public String toString() {
		return "Utente [username=" + username + ", pwd=" + pwd + ", nome=" + nome + ", codfisc=" + codfisc
				+ ", listaCarrello=" + listaCarrello + "]";
	}
}
