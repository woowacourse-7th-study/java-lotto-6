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

    public static void printRankResult(Rank rank, int count) {
        switch (rank) {
            case FIFTH:
                System.out.printf("3개 일치 (5,000원) - %d개%n", count);
                break;
            case FIRTH:
                System.out.printf("4개 일치 (50,000원) - %d개%n", count);
                break;
            case THIRD:
                System.out.printf("5개 일치 (1,500,000원) - %d개%n", count);
                break;
            case SECOND:
                System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", count);
                break;
            case FIRST:
                System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", count);
                break;
            default:
                System.out.printf("일치하는 번호 없음 - %d개%n", count);
                break;
        }
    }



    private static void printWhiteSpace(){
        System.out.println();
    }
}
