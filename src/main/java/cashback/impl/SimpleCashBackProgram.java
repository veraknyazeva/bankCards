package cashback.impl;

import cashback.api.CashBack;

public class SimpleCashBackProgram implements CashBack {
    private static final double SIMPLE_CASHBACK_RATE = 0.01;

    @Override
    public double calculateCashBackValue(double sum) {
        return sum * SIMPLE_CASHBACK_RATE;
    }
}
