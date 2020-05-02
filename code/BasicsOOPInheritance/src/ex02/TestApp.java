package ex02;

/**
 * Aprire la cartella doc/ all’interno del progetto corrente. Scrivere il codice
 * Java relativo alla documentazione (index.html) delle classi contenute nel
 * package ex02. In particolare, le due classi da implementare (BankAccount,
 * SavingsAccount) devono funzionare con il main sottostante.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		SavingsAccount ac01 = new SavingsAccount(5000, 0.01);
		SavingsAccount ac02 = new SavingsAccount(10000, 0.02);

		ac01.deposit(1000);
		ac01.transfer(1000, ac02);

		ac01.withdraw(500);
		ac02.withdraw(500);

		ac01.deposit(ac01.calculateInterest());
		ac02.deposit(ac02.calculateInterest());

		System.out.println(ac01);
		System.out.println(ac02);
	}
}