package lotto.constant;

public enum ViewMessage {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ENTER_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_PURCHASE_NUMBERS("%d개를 구매했습니다."),
    PRINT_WINNING_STATISTICS_HEADER("당첨 통계\n---"),
    PRINT_WINNING_STATISTICS("%d개 일치 (%s원) - %d개"),
    PRINT_RATE_OF_RETURN("총 수익률은 %.1f%입니다."),
    PRINT_ERROR_MESSAGE("%s %s");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
