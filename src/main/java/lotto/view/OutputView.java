package lotto.view;

import lotto.constant.ViewMessage;
import lotto.exception.ErrorCode;
import lotto.exception.ErrorMessage;

public class OutputView {
    private OutputView() {
    }

    public static void printErrorMessage(ErrorMessage errorMessage) {
        String result = addPrefix(errorMessage);
        System.out.println(result);
    }

    private static String addPrefix(ErrorMessage errorMessage) {
        String outputFormat = ViewMessage.PRINT_ERROR_MESSAGE.toString();
        return String.format(outputFormat, ErrorCode.PREFIX, errorMessage);
    }

}
