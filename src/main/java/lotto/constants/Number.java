package lotto.constants;

public enum Number {
    RANGE_START(1),
    RANGE_END(45),
    MAX_COUNT(6),
    UNIT(1000),
    MIN_COUNT_FOR_PRIZE(3),
    WINNERS_COUNT(5);

    private final Integer value;

    Number(final Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
