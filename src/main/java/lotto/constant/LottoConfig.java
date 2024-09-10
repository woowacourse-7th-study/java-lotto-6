package lotto.constant;

public enum LottoConfig {
    PRICE_UNIT(1000),
    PRICE_MIN(1000),
    ;

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
