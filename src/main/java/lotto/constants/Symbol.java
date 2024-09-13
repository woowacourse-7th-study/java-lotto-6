package lotto.constants;

public enum Symbol {
    COMMA(",");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
