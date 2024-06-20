package cashback.impl;

import cashback.api.Bonus;

public class StudentBonusProgram implements Bonus {

    private static final double LOYALTY_PROGRAM_RATE = 0.02;

    @Override
    public double calculateBonusValue(double sum) {
        return sum * LOYALTY_PROGRAM_RATE;
    }
}
