package lotto.view;

import lotto.constant.Ranking;
import lotto.constant.ViewMessage;
import lotto.domain.dto.LottosData;
import lotto.domain.dto.ResultData;

import static lotto.constant.ErrorMessage.PREFIX;
import static lotto.constant.ViewMessage.PRINT_ERROR_MESSAGE;

public class OutputView {
    private OutputView() {
    }

    public static void printErrorMessage(String message) {
        System.out.println();
        String errorMessage = String.format(PRINT_ERROR_MESSAGE.toString(), PREFIX, message);
        System.out.println(errorMessage);
    }

    public static void printQuantity(LottosData lottosData) {
        System.out.println();
        Integer size = lottosData.size();
        String purchaseCountMessage = String.format(ViewMessage.PRINT_PURCHASE_NUMBERS.toString(), size);
        System.out.println(purchaseCountMessage);
    }

    public static void printLottosNumbers(LottosData lottosData) {
        Integer size = lottosData.size();
        for (int i = 0; i < size; i++) {
            System.out.println(lottosData.lottos().get(i));
        }
    }

    public static void printResultHeader() {
        System.out.println();
        System.out.println(ViewMessage.PRINT_WINNING_STATISTICS_HEADER);
    }

    public static void printResult(ResultData resultData) {
        Integer[] winningLottoCount = resultData.winningLottoCount();
        Double rateOfReturn = resultData.rateOfReturn();
        printCount(winningLottoCount);
        printRateOfReturn(rateOfReturn);
    }

    private static void printCount(Integer[] winningLottoCount) {
        for (Ranking ranking : Ranking.values()) {
            Integer count = winningLottoCount[ranking.ordinal()];
            String message = String.format(ViewMessage.PRINT_WINNING_STATISTICS.toString(),
                    ranking.getNumberCount(),
                    ranking.getPrize(),
                    count);
            System.out.println(message);
        }

    }

    private static void printRateOfReturn(Double rateOfReturn) {
        String message = String.format(ViewMessage.PRINT_RATE_OF_RETURN.toString(),
                rateOfReturn);
        System.out.println(message);
    }
}
