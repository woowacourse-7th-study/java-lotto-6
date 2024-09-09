package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ViewMessage;

public class InputView {
    private InputView() {
    }

    public static String inputPurchaseAmount() {
        System.out.println(ViewMessage.ENTER_PURCHASE_AMOUNT);
        return Console.readLine();
    }
}
