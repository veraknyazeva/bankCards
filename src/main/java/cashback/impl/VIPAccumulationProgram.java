package cashback.impl;

import cashback.api.Accumulation;

public class VIPAccumulationProgram implements Accumulation {
    private static final double ACCUMULATION = 0.00006;

    @Override
    public double calculateAccumulationValue(double sum) {
        return sum * ACCUMULATION;
    }
}
