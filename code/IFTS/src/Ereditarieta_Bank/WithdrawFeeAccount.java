package Ereditarieta_Bank;

public class WithdrawFeeAccount extends Account {

	public WithdrawFeeAccount(String name, double amount) {
		super(name, amount);
	}

	@Override
	public double deposit(double n) {
		amount += n;
		return amount;
	}

	@Override
	public double withdraw(double n) {
		amount -= n + (n * withdrawFEE);
		return amount;
	}

}
