package cashback.impl;

import cashback.api.Accumulation;

public class StudentAccumulationProgram implements Accumulation {
    private static final double ACCUMULATION = 0.00005;

    @Override
    public double calculateAccumulationValue(double sum) {
        return sum * ACCUMULATION;
    }
}
