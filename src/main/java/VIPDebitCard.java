import cashback.api.Accumulation;
import cashback.api.Bonus;
import cashback.api.CashBack;
import cashback.impl.NoAccumulationProgram;
import cashback.impl.NoBonusProgram;
import cashback.impl.NoCashBackProgram;

//если сумма покупок более 50 000 в месяц, то начисляются 5000 бонусов
//с каждого начисления накопление 0.006%, если начислений больше 100 000 в месяц, то плюсом 1000 бонусов
//с каждой оплааты кешбек 7%, если покупка больше 10000к //если оплата больше 20 000, то 10%
//с каждой оплаты бонусы 3%
public class VIPDebitCard extends DebitCard {
    private double totalAmountChargedForTheMonth; //общая сумма начислений за месяц
    private double totalPurchasesForTheMonth; //общая сумма покупок за месяц
    private double bonusPoints;
    private double potentialCashback;
    private CashBack cashBackProgram = new NoCashBackProgram();
    private Bonus bonusProgram = new NoBonusProgram();
    private Accumulation accumulationProgram = new NoAccumulationProgram();

    public void setCashBackProgram(CashBack cashBackProgram) {
        this.cashBackProgram = cashBackProgram;
    }

    public void setBonusProgram(Bonus bonusProgram) {
        this.bonusProgram = bonusProgram;
    }

    public void setAccumulationProgram(Accumulation accumulationProgram) {
        this.accumulationProgram = accumulationProgram;
    }


    @Override
    public double increase(double sum) {
        this.balance = this.balance + sum + accumulationProgram.calculateAccumulationValue(sum);
        totalAmountChargedForTheMonth += sum;
        return this.balance;
    }

    //с каждого начисления накопление 0.006%
    //с каждой оплааты кешбек 7%, если покупка больше 10000к //если оплата больше 20 000, то 10%
    //с каждой оплаты бонусы 3%
    @Override
    public boolean pay(double sum) {
        boolean isSuccess = super.pay(sum);
        if (isSuccess) {
            double cashBack = cashBackProgram.calculateCashBackValue(sum);
            potentialCashback += cashBack;
            this.balance += cashBack;
            bonusPoints += bonusProgram.calculateBonusValue(sum);
            totalPurchasesForTheMonth += sum;
        }
        return isSuccess;
    }

    @Override
    public double getInformationAboutAvailableFunds() {
        System.out.println("Бонусные баллы: " + bonusPoints);
        System.out.println("Накопленный кешбек: " + potentialCashback);
        System.out.println("Сумма общих покупок: " + totalPurchasesForTheMonth);
        System.out.println("Сумма общих начислений: " + totalAmountChargedForTheMonth);
        return this.balance;
    }
}
