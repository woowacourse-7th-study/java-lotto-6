package lotto.controller;

import lotto.service.PurchaseAmountValidator;
import lotto.view.InputView;

public class LottoController {
    private final PurchaseAmountValidator purchaseAmountValidator;

    public LottoController() {
        this.purchaseAmountValidator = new PurchaseAmountValidator();
    }

    public void run() {
        inputPurchaseAmount();
    }

    private void inputPurchaseAmount() {
        String input = InputView.inputPurchaseAmount();
        purchaseAmountValidator.validatePurchaseAmount(input);
    }
}
