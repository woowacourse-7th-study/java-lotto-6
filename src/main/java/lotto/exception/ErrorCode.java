package lotto.exception;

public enum ErrorCode {
    PREFIX("[ERROR]");

    final String prefix;

    ErrorCode(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return prefix;
    }
}
