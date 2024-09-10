package lotto.controller;

import lotto.view.InputView;

public class LottoGame {
    public void run() {
        inputBuyLotto();
    }

    public void inputBuyLotto(){
        String userPrice = InputView.requestPrice();
    }
}
