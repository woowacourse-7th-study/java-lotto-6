package lotto.constant;

public enum Profit {
    FIFTH(5_000L),
    FOURTH(50_000L),
    THIRD(1_500_000L),
    SECOND(30_000_000L),
    FIRST(2_000_000_000L);

    private final Long profit;

    Profit(final Long profit) {
        this.profit = profit;
    }

    public long getProfit() {
        return profit;
    }
}
