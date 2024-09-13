package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constants.ViewMessage.ENTER_BONUS_NUMBER;
import static lotto.constants.ViewMessage.ENTER_PURCHASE_AMOUNT;
import static lotto.constants.ViewMessage.ENTER_WINNING_NUMBERS;

public class InputView {
    private InputView() {
    }

    public static String inputPurchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println();
        System.out.println(ENTER_WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println();
        System.out.println(ENTER_BONUS_NUMBER);
        return Console.readLine();
    }
}
