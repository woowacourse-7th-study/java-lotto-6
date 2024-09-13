package lotto.view;

import lotto.constant.Ranking;
import lotto.domain.dto.LottosDto;
import lotto.domain.dto.ResultDto;

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

    public static void printQuantity(final LottosDto lottosDto) {
        System.out.println();
        Integer size = lottosDto.size();
        String purchaseCountMessage = String.format(PRINT_PURCHASE_NUMBERS.toString(), size);
        System.out.println(purchaseCountMessage);
    }

    public static void printLottosNumbers(final LottosDto lottosDto) {
        int size = lottosDto.size();
        for (int i = 0; i < size; i++) {
            System.out.println(lottosDto.lottos().get(i));
        }
    }

    public static void printResultHeader() {
        System.out.println();
        System.out.println(PRINT_WINNING_STATISTICS_HEADER);
    }

    public static void printResult(final ResultDto resultDto) {
        Integer[] winningLottoCount = resultDto.winningLottoCount();
        Double rateOfReturn = resultDto.rateOfReturn();
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
