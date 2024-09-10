package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String PRICE_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";

    public static String requestPrice(){
        System.out.println(PRICE_REQUEST_MESSAGE);

        return requestInput();
    }

    private static String requestInput(){
        return Console.readLine();
    }
}
