package lotto.service;

import lotto.dto.PurchasePriceDto;
import lotto.model.PurchasePrice;
import lotto.validator.UserInputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class PurchasePriceService {

    public PurchasePriceDto inputPurchasePrice() {
        return validPurchasePrice();
    }

    private PurchasePriceDto validPurchasePrice() {
        while (true) {
            try {
                return attemptInputPurchasePrice();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private PurchasePriceDto attemptInputPurchasePrice() {
        String input = InputView.inputPurchaseAmount();
        UserInputValidator.validateStrip(input);
        UserInputValidator.validateInteger(input);
        Integer price = Integer.parseInt(input);
        PurchasePrice purchasePrice = new PurchasePrice(price);
        return new PurchasePriceDto(purchasePrice);
    }
}