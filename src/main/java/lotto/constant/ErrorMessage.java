package lotto.constant;

public enum ErrorMessage {
    PREFIX("[ERROR]"),
    ENTER_INTEGER("정수를 입력해야 합니다."),
    ENTER_THOUSAND("1,000원 단위로 입력해야 합니다."),
    ENTER_NUMBER_IN_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ENTER_NUMBERS_WITH_COMMA("당첨 번호는 쉼표(,)를 기준으로 나누어 입력해야 합니다."),
    ENTER_SIX_NUMBERS("6개의 정수를 입력해야 합니다."),
    ENTER_NUMBERS_NOT_DUPLICATED("중복되지 않는 정수를 입력해야 합니다."),
    ENTER_BONUS_NUMBER_NOT_DUPLICATED("보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
    NOT_ALLOWED_WHITESPACE("입력 문자열의 앞, 뒤에는 공백이 포함되지 않아야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
