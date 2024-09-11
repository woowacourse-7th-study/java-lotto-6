package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String PRICE_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNIG_LOTTO_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_LOTTO_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String requestPrice() {
        System.out.println(PRICE_REQUEST_MESSAGE);

        return requestInputPrice();
    }

    private static String requestInputPrice() {
        return Console.readLine();
    }

    public static String requestWinningLotto(){
        System.out.println(WINNIG_LOTTO_REQUEST_MESSAGE);

        return requestInputWinnigLotto();
    }

    private static String requestInputWinnigLotto(){
        return Console.readLine();
    }

    public static String requestBonusLotto(){
        printWhiteSpace();
        System.out.println(BONUS_LOTTO_REQUEST_MESSAGE);

        return requestInputBonusLotto();
    }

    private static String requestInputBonusLotto(){
        return Console.readLine();
    }

    private static void printWhiteSpace(){
        System.out.println();
    }
}
