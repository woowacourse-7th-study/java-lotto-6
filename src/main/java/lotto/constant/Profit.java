package lotto.constant;

public enum Profit {
    FIFTH(5_000),
    FOURTH(50_000),
    THIRD(1_500_000),
    SECOND(30_000_000),
    FIRST(2_000_000_000);

    private final long profit;

    Profit(int profit) {
        this.profit = profit;
    }

    public long getProfit() {
        return profit;
    }
}
