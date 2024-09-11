package lotto.view;

import lotto.constant.ViewMessage;
import lotto.domain.dto.LottosData;

import static lotto.constant.ErrorMessage.PREFIX;
import static lotto.constant.ViewMessage.PRINT_ERROR_MESSAGE;

public class OutputView {
    private OutputView() {
    }

    public static void printErrorMessage(String message) {
        String errorMessage = String.format(PRINT_ERROR_MESSAGE.toString(), PREFIX, message);
        System.out.println(errorMessage);
    }

    public static void printQuantity(LottosData lottosData) {
        Integer size = lottosData.size();
        System.out.println();
        String purchaseCountMessage = String.format(ViewMessage.PRINT_PURCHASE_NUMBERS.toString(), size);
        System.out.println(purchaseCountMessage);
    }

    public static void printLottosNumbers(LottosData lottosData) {
        Integer size = lottosData.size();
        for (int i = 0; i < size; i++) {
            System.out.println(lottosData.lottos().get(i));
        }
    }


}
