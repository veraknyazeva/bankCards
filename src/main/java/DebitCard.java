public class DebitCard extends BankCard {

    public double increase(double sum) {
        this.balance += sum;
        return this.balance;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public boolean pay(double sum) {
        if (this.balance < sum) {
            return false;
        } else {
            this.balance -= sum;
            return true;
        }
    }

    @Override
    public double getInformationAboutAvailableFunds() {
        return this.balance;
    }
}