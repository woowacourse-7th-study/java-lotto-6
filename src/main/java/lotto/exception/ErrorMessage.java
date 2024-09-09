package lotto.exception;

public enum ErrorMessage {
    ENTER_INTEGER("정수를 입력해야 합니다."),
    ENTER_THOUSAND("1,000원 단위로 입력해야 합니다.");

    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
