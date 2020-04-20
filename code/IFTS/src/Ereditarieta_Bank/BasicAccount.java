package Ereditarieta_Bank;

public class BasicAccount extends Account {

	public BasicAccount(String name, double amount) {
		super(name, amount);
	}

	@Override
	public double deposit(double n) {
		amount += n;
		return amount;
	}

	@Override
	public double withdraw(double n) {
		amount -= n;
		return amount;
	}

}
