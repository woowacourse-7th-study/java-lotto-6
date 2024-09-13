package lotto.view;

import lotto.domain.model.Lotto;
import lotto.domain.model.Rank;

import java.util.List;

import static lotto.constant.ViewMessage.*;

public class OutputView {

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printLottoCount(int lottoCount){
        printWhiteSpace();
        System.out.println(lottoCount + "" + LOTTO_COUNT_NOTICE);
    }

    public static void printRandomLottos(List<Lotto> randomLottos){
        StringBuilder lottoBuilder = new StringBuilder();
        randomLottos.forEach(lotto ->
            lottoBuilder.append(lotto.getLottoNumbers()).append("\n")
        );
        System.out.println(lottoBuilder.toString());
    }

    public static void printHeaderNotice(){
        printWhiteSpace();
        System.out.println(WINNING_STATISTICS);
        printLine();
    }

    private static void printLine(){
        System.out.println(SEPARATOR);
    }

    public static void printTotalRate(float totalRate) {
        System.out.printf(TOTAL_RATE_FORMAT.toString(), totalRate);
    }

    private static void printWhiteSpace(){
        System.out.println();
    }
}
