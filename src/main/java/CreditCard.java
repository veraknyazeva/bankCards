public class CreditCard extends BankCard {
    private double creditLimit;
    private double creditBalance;
    private double personalBalance;

    private CreditCard() {

    }

    public CreditCard(double creditLimit) {
        this.creditLimit = creditLimit;
        this.creditBalance = creditLimit;
        this.personalBalance = 0;
        this.balance = personalBalance + creditBalance;
    }

    public double increase(double sum) {
        double tmpCreditBalance = creditBalance + sum;
        if (creditBalance == creditLimit) {
            personalBalance += sum;
        } else {
            if (tmpCreditBalance <= creditLimit) {
                creditBalance += sum;
            } else {
                double remainder = tmpCreditBalance - creditLimit;
                personalBalance += remainder;
                creditBalance = creditLimit;
            }
        }
        this.balance = personalBalance + creditBalance;
        return this.balance;
    }

    @Override
    public boolean pay(double sum) {
        if (this.balance < sum) {
            return false;
        } else {
            if (personalBalance >= sum) {
                personalBalance -= sum;
                this.balance = creditBalance + personalBalance;
                return true;
            } else {
                double remainder = sum - personalBalance;
                personalBalance = 0;
                creditBalance -= remainder;
                this.balance = creditBalance + personalBalance;
                return true;
            }
        }
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public double getInformationAboutAvailableFunds() {
        System.out.println("Кредитные средства: " + creditBalance);
        System.out.println("Собственные средства: " + personalBalance);
        return this.balance;
    }
}
