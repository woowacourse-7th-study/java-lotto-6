package lotto.view;

import lotto.domain.model.Lotto;
import lotto.domain.model.Rank;

import java.util.List;

public class OutputView {
    private static final String LOTTO_COUNT_NOTICE = "개를 구매했습니다.";
    private static final String WINNING_STATICSTICS = "당첨 통계";
    private static final String SEPARATOR = "---";

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printLottoCount(int lottoCount){
        printWhiteSpace();
        System.out.println(lottoCount + LOTTO_COUNT_NOTICE);
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
        System.out.println(WINNING_STATICSTICS);
        printLine();
    }

    private static void printLine(){
        System.out.println(SEPARATOR);
    }

    private static void printWhiteSpace(){
        System.out.println();
    }
}
