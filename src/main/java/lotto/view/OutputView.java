package lotto.view;

import lotto.domain.model.Lotto;

import java.util.List;

public class OutputView {
    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printLottoCount(int lottoCount){
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printRandomLottos(List<Lotto> randomLottos){
        StringBuilder lottoBuilder = new StringBuilder();
        randomLottos.forEach(lotto ->
            lottoBuilder.append(lotto.getLottoNumbers()).append("\n")
        );
        System.out.println(lottoBuilder.toString());
    }
}
