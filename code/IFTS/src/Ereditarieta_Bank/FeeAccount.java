package Ereditarieta_Bank;

public class FeeAccount extends Account {
	public final static int FEE = 2;

	public FeeAccount(int amount) {
		super(amount);
	}

	public int withdraw(int n) {
		amount -= FEE;
		return super.withdraw(n);
	}
}
