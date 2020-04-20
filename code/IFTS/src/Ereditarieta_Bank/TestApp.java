package Ereditarieta_Bank;

public class TestApp {

	public static void main(String[] args) {
		Account a = new DepositFeeAccount("Nicola", 1000);
		Account b = new WithdrawFeeAccount("Luca", 1000);

		System.out.println(a);
		a.deposit(100);
		System.out.println(a);
		a.withdraw(200);
		System.out.println(a);

		System.out.println(b);
		b.deposit(100);
		System.out.println(b);
		b.withdraw(200);
		System.out.println(b);
	}

}
