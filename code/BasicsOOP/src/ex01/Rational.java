package ex01;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Implementare una classe Rational che rappresenta un numero razionale in
 * maniera esatta.
 * 
 * Il costruttore accetta numeratore e denominatore. Se il denominatore è
 * negativo,viene lanciata una eccezione.
 * 
 * Il metodo plus()prende un altro Rational x come argomento e restituisce la
 * somma di this e x. Il metodo times()prende un altro Rational x come argomento
 * e restituisce il prodotto di this e x.
 * 
 * La classe Rational deve inoltre implementare l’interfaccia
 * Comparable<Rational>, in base al normale ordinamento tra
 * razionali(crescente).
 * 
 * Fornire infine la classe di metodo main dimostrativo.
 * 
 * @author Nicola Bicocchi
 * 
 */

public class Rational implements Comparable<Rational> {
	int num;
	int den;

	public Rational(int num, int den) {
		super();
		if (den <= 0) {
			throw new RuntimeException();
		}
		this.num = num;
		this.den = den;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getDen() {
		return den;
	}

	public void setDen(int den) {
		this.den = den;
	}

	public Rational plus(Rational o) {
		int num = this.num * o.getDen() + o.getNum() * this.den;
		int den = this.den * o.getDen();
		return new Rational(num, den);
	}

	public Rational times(Rational o) {
		int num = this.num * o.getNum();
		int den = this.den * o.getDen();
		return new Rational(num, den);
	}

	@Override
	public int compareTo(Rational o) {
		return Double.compare(num / (double) den,
				o.getNum() / (double) o.getDen());
	}

	@Override
	public String toString() {
		return "Rational [num=" + num + ", den=" + den + "]";
	}

	public static void main(String[] args) {
		ArrayList<Rational> l = new ArrayList<Rational>();
		// l.add(new Rational(1, 0));
		l.add(new Rational(1, 3));
		l.add(new Rational(1, 9));
		l.add(new Rational(1, 2).plus(new Rational(1, 2)));
		l.add(new Rational(1, 2).times(new Rational(1, 2)));

		System.out.println(l);
		Collections.sort(l);
		System.out.println(l);
	}
}
