package Ereditarieta_Bank;

public abstract class Account implements AccountInt {
	public static final double FEE = 0.01;
	String name;
	double amount;

	public Account(String name, double amount) {
		super();
		this.name = name;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Account [amount=" + amount + "]";
	}

}
