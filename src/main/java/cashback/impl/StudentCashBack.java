package cashback.impl;

import cashback.api.CashBack;

public class StudentCashBack implements CashBack {
    private static final double STUDENT_CASHBACK_RATE = 0.05;

    @Override
    public double calculateCashBackValue(double sum) {
        return sum * STUDENT_CASHBACK_RATE;
    }
}
