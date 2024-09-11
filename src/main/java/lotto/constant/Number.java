package lotto.constant;

public enum Number {
    RANGE_START(1),
    RANGE_END(45),
    MAX_COUNT(6);

    private final Integer value;

    Number(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
