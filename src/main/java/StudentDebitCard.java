import cashback.api.Accumulation;
import cashback.api.Bonus;
import cashback.api.CashBack;
import cashback.impl.NoAccumulationProgram;
import cashback.impl.NoBonusProgram;
import cashback.impl.NoCashBackProgram;

public class StudentDebitCard extends DebitCard {
    private static final double CASH_BARRIER = 5000.00;
    private double bonusPoints;
    private double potentialCashback;
    private CashBack cashBackProgram = new NoCashBackProgram();
    private Bonus bonusProgram = new NoBonusProgram();
    private Accumulation accumulation = new NoAccumulationProgram();

    public void setAccumulation(Accumulation accumulation) {
        this.accumulation = accumulation;
    }

    public void setCashBackProgram(CashBack cashBackProgram) {
        this.cashBackProgram = cashBackProgram;
    }

    public void setBonusProgram(Bonus bonusProgram) {
        this.bonusProgram = bonusProgram;
    }

    //Накопление в размере 0.005% от суммы пополнений
    @Override
    public double increase(double sum) {
        this.balance = this.balance + sum + accumulation.calculateAccumulationValue(sum);
        return this.balance;
    }

    //Бонусные баллы в размере 2% от покупок.
    //Потенциальный кэшбэк 5% от покупок при условии трат больше 5000 тыс.
    @Override
    public boolean pay(double sum) {
        if (this.balance < sum) {
            return false;
        } else {
            if (sum > CASH_BARRIER) {
                double paymentCashback = cashBackProgram.calculateCashBackValue(sum);
                potentialCashback += paymentCashback;
                this.balance = this.balance - sum + paymentCashback;
                bonusPoints += bonusProgram.calculateBonusValue(sum);
                return true;
            } else {
                this.balance -= sum;
                bonusPoints += bonusProgram.calculateBonusValue(sum);
                return true;
            }
        }
    }


    @Override
    public double getInformationAboutAvailableFunds() {
        System.out.println("Бонусные баллы: " + bonusPoints);
        System.out.println("Накопленный кешбек: " + potentialCashback);
        return this.balance;
    }
}
