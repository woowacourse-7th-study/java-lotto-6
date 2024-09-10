package lotto.constant.exception.error;

import static lotto.constant.LottoConfig.PRICE_MIN;
import static lotto.constant.LottoConfig.PRICE_UNIT;

public enum ErrorMessage {
    INVALID_PRICE_INTEGER("정수로 된 금액만 입력할 수 있습니다."),
    INVALID_PRICE_UNIT(PRICE_UNIT + "원 단위의 금액만 입력할 수 있습니다."),
    INVALID_PRICE_MIN(PRICE_MIN + "원 미만의 금액은 입력할 수 없습니다.");

    private static final String PREFIX = "[ERROR] "; // PREFIX는 항상 같은 값을 가짐

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
