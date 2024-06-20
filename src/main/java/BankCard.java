

public abstract class BankCard {
    protected double balance;

    public abstract boolean pay(double sum);

    public abstract double getBalance();

    public abstract double getInformationAboutAvailableFunds();
}
