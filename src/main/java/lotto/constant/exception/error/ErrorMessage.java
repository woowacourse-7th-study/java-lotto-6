package lotto.constant.exception.error;

import static lotto.constant.LottoConfig.*;

public enum ErrorMessage {
    INVALID_PRICE_INTEGER("정수로 된 금액만 입력할 수 있습니다."),
    INVALID_PRICE_UNIT(PRICE_UNIT + "원 단위의 금액만 입력할 수 있습니다."),
    INVALID_PRICE_MIN(PRICE_MIN + "원 미만의 금액은 입력할 수 없습니다."),
    INVALID_REQUIRED_LENGTH("당첨 번호는 " + LOTTO_COUNT + "개를 입력해야 합니다."),
    OUT_OF_RANGE(RANGE_MIN + "부터 " + RANGE_MAX + "의 숫자만 입력할 수 있습니다."),
    INVALID_DUPLICATION("중복되는 수를 입력할 수 없습니다.");

    private static final String PREFIX = "[ERROR] "; // PREFIX는 항상 같은 값을 가짐

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
