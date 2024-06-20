package cashback.api;

public interface Bonus {
    default double calculateBonusValue(double sum) {
        return 0;
    }
}
