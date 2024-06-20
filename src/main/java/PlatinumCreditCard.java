import cashback.api.CashBack;
import cashback.impl.VIPCashBackProgram;

public class PlatinumCreditCard extends CreditCard{
    private static final double LIMIT = 100_000;
    private double potentialCashback;
    private final CashBack cashBackProgram = new VIPCashBackProgram();

    public PlatinumCreditCard() {
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
