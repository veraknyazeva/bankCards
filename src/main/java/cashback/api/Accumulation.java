package cashback.api;

public interface Accumulation {
    default double calculateAccumulationValue(double sum) {
        return 0;
    }
}
