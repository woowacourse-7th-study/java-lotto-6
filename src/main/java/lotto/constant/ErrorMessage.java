package lotto.constant;

public enum ErrorMessage {
    INVALID_PRICE_INTEGER("정수로 된 금액만 입력할 수 있습니다."),
    INVALID_PRICE_UNIT("1000원 단위의 금액만 입력할 수 있습니다."),
    INVALID_PRICE_MIN("1000원 미만의 금액은 입력할 수 없습니다.");

    private static final String PREFIX = "[ERROR] "; // PREFIX는 항상 같은 값을 가짐

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
