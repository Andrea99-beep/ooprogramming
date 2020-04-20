package Ereditarieta_Bank;

public abstract class Account implements AccountInt {
	public static final double withdrawFEE = 0.01;
	public static final double depositFEE = 0.005;
	String name;
	double amount;

	public Account(String name, double amount) {
		super();
		this.name = name;
		this.amount = amount;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", amount=" + amount + "]";
	}

}
