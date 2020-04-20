package Ereditarieta_Bank;

public class DepositFeeAccount extends Account {

	public DepositFeeAccount(String name, double amount) {
		super(name, amount);
	}

	@Override
	public double deposit(double n) {
		amount += n - (n * depositFEE);
		return amount;
	}

	@Override
	public double withdraw(double n) {
		amount -= n;
		return amount;
	}
}
