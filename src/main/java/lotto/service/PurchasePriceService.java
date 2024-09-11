package lotto.service;

import lotto.constant.ErrorMessage;
import lotto.domain.dto.PurchasePriceData;
import lotto.domain.model.PurchasePrice;
import lotto.view.InputView;
import lotto.view.OutputView;

public class PurchasePriceService {

    public PurchasePriceData inputPurchasePrice() {
        return validPurchasePrice();
    }

    private PurchasePriceData validPurchasePrice() {
        while (true) {
            try {
                return attemptInputPurchasePrice();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private PurchasePriceData attemptInputPurchasePrice() {
        String input = InputView.inputPurchaseAmount();
        validateStrip(input);
        validateInteger(input);
        Integer price = Integer.parseInt(input);
        PurchasePrice purchasePrice = new PurchasePrice(price);
        return new PurchasePriceData(purchasePrice);
    }

    private void validateStrip(final String input) {
        String stripped = input.strip();
        if (input.equals(stripped)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_ALLOWED_WHITESPACE.toString());
    }

    private void validateInteger(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_INTEGER.toString());
        }
    }
}