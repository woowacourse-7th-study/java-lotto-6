package lotto.constants;

public enum Ranking {

    FIFTH(3, " (5,000원)"),
    FOURTH(4, " (50,000원)"),
    THIRD(5, " (1,500,000원)"),
    SECOND(5, ", 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, " (2,000,000,000원)");

    private final Integer numberCount;
    private final String prize;

    Ranking(final Integer numberCount, final String prize) {
        this.numberCount = numberCount;
        this.prize = prize;
    }

    public Integer getNumberCount() {
        return numberCount;
    }

    public String getPrize() {
        return prize;
    }
}
