package cashback.impl;

import cashback.api.CashBack;

public class VIPCashBackProgram implements CashBack {
    private static final double CASH_BARRIER = 10_000.00;
    private static final double MAX_CASH_BARRIER = 20_000.00;
    private static final double VIP_CASHBACK_RATE_FOR_CASH_BARRIER = 0.07;
    private static final double VIP_CASHBACK_RATE_FOR_MAX_CASH_BARRIER = 0.1;

    @Override
    public double calculateCashBackValue(double sum) {
        if (sum >= CASH_BARRIER && sum < MAX_CASH_BARRIER) {
            return sum * VIP_CASHBACK_RATE_FOR_CASH_BARRIER;
        } else if (sum >= MAX_CASH_BARRIER) {
            return sum * VIP_CASHBACK_RATE_FOR_MAX_CASH_BARRIER;
        } else {
            return 0;
        }
    }
}