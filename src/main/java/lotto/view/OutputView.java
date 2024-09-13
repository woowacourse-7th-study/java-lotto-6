package lotto.view;

import lotto.constant.Ranking;
import lotto.domain.dto.LottosData;
import lotto.domain.dto.ResultData;

import static lotto.constant.ErrorMessage.PREFIX;
import static lotto.constant.ViewMessage.*;

public class OutputView {
    private OutputView() {
    }

    public static void printErrorMessage(String message) {
        System.out.println();
        String errorMessage = String.format(PRINT_ERROR_MESSAGE.toString(), PREFIX, message);
        System.out.println(errorMessage);
    }

    public static void printQuantity(final LottosData lottosData) {
        System.out.println();
        Integer size = lottosData.size();
        String purchaseCountMessage = String.format(PRINT_PURCHASE_NUMBERS.toString(), size);
        System.out.println(purchaseCountMessage);
    }

    public static void printLottosNumbers(final LottosData lottosData) {
        Integer size = lottosData.size();
        for (int i = 0; i < size; i++) {
            System.out.println(lottosData.lottos().get(i));
        }
    }

    public static void printResultHeader() {
        System.out.println();
        System.out.println(PRINT_WINNING_STATISTICS_HEADER);
    }

    public static void printResult(final ResultData resultData) {
        Integer[] winningLottoCount = resultData.winningLottoCount();
        Double rateOfReturn = resultData.rateOfReturn();
        printCount(winningLottoCount);
        printRateOfReturn(rateOfReturn);
    }

    private static void printCount(final Integer[] winningLottoCount) {
        for (Ranking ranking : Ranking.values()) {
            Integer count = winningLottoCount[ranking.ordinal()];
            String message = String.format(PRINT_WINNING_STATISTICS.toString(),
                    ranking.getNumberCount(),
                    ranking.getPrize(),
                    count);
            System.out.println(message);
        }
    }

    private static void printRateOfReturn(final Double rateOfReturn) {
        String message = String.format(PRINT_RATE_OF_RETURN.toString(),
                rateOfReturn);
        System.out.println(message);
    }
}
