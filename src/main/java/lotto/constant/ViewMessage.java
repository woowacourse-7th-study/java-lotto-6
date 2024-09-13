package lotto.constant;

public enum ViewMessage {

    // Input Messages
    PRICE_REQUEST_MESSAGE("구입금액을 입력해 주세요."),
    WINNING_LOTTO_REQUEST_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_LOTTO_REQUEST_MESSAGE("보너스 번호를 입력해 주세요."),

    // Output Messages
    LOTTO_COUNT_NOTICE("개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계"),
    SEPARATOR("---"),
    TOTAL_RATE_FORMAT("총 수익률은 %.1f%%입니다.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;  // Enum 값이 호출될 때 문자열을 반환
    }
}
