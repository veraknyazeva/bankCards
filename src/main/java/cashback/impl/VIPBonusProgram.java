package cashback.impl;

import cashback.api.Bonus;

public class VIPBonusProgram implements Bonus {
    private static final double LOYALTY_PROGRAM_RATE = 0.03;
    private static final double GIFT_BONUSES_SUM_PURCHASE = 5000.00;
    private static final double GIFT_BONUSES_ACCRUAL_AMOUNT = 1000.00;
    private static final double ACCRUAL_AMOUNT = 100_000.00; //начислений
    private static final double SUM_PURCHASE = 50_000.00; //сумма покупок


    public double calculateGiftBonuses(double totalAmountChargedForTheMonth, double totalPurchasesForTheMonth) {
        if (totalAmountChargedForTheMonth > ACCRUAL_AMOUNT && totalPurchasesForTheMonth > SUM_PURCHASE) {
            return GIFT_BONUSES_ACCRUAL_AMOUNT + GIFT_BONUSES_SUM_PURCHASE;
        } else if (totalAmountChargedForTheMonth > ACCRUAL_AMOUNT) {
            return GIFT_BONUSES_ACCRUAL_AMOUNT;
        } else if (totalPurchasesForTheMonth > SUM_PURCHASE) {
            return GIFT_BONUSES_ACCRUAL_AMOUNT;
        }
        return 0;
    }

    @Override
    public double calculateBonusValue(double sum) {
        return sum * LOYALTY_PROGRAM_RATE;
    }
}