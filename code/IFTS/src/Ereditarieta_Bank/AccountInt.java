package Ereditarieta_Bank;

public interface AccountInt {
	public String getName();

	public void setName(String name);

	public double getAmount();

	public double deposit(double n);

	public double withdraw(double n);
}
