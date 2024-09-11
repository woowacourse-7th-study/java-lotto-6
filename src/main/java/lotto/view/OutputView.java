package lotto.view;

import static lotto.constant.ErrorMessage.PREFIX;
import static lotto.constant.ViewMessage.PRINT_ERROR_MESSAGE;

public class OutputView {
    private OutputView() {
    }

    public static void printErrorMessage(String message) {
        String errorMessage = String.format(PRINT_ERROR_MESSAGE.toString(), PREFIX, message);
        System.out.println(errorMessage);
    }
}
