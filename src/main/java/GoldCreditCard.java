import cashback.api.CashBack;
import cashback.impl.SimpleCashBackProgram;

public class GoldCreditCard extends CreditCard {
    private static final double LIMIT = 50_000;
    private double potentialCashback;
    private final CashBack cashBackProgram = new SimpleCashBackProgram();

    public GoldCreditCard() {
        super(LIMIT);
    }

    @Override
    public boolean pay(double sum) {
        boolean isSuccess = super.pay(sum);
        if (isSuccess) {
            double cashBack = cashBackProgram.calculateCashBackValue(sum);
            potentialCashback += cashBack;
            super.increase(cashBack);
        }
        return isSuccess;
    }

    @Override
    public double getInformationAboutAvailableFunds() {
        System.out.println("Накопленный кешбек: " + potentialCashback);
        return super.getInformationAboutAvailableFunds();
    }
}
