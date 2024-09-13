package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.ViewMessage.*;

public class InputView {

    public static String requestPrice() {
        System.out.println(PRICE_REQUEST_MESSAGE);

        return requestInputPrice();
    }

    private static String requestInputPrice() {
        return Console.readLine();
    }

    public static String requestWinningLotto(){
        System.out.println(WINNING_LOTTO_REQUEST_MESSAGE);

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
