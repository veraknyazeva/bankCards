package cashback.api;

public interface CashBack {
    default double calculateCashBackValue(double sum){
        return 0.00;
    }
}
