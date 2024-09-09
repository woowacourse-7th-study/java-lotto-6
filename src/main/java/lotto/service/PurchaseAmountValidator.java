package lotto.service;

import lotto.exception.ErrorMessage;
import lotto.view.OutputView;

public class PurchaseAmountValidator {

    public void validatePurchaseAmount(String input) {
        checkInteger(input);
        int purchaseAmount = Integer.parseInt(input);
        checkUnit(purchaseAmount);
    }

    private void checkInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(ErrorMessage.ENTER_INTEGER);
        }
    }

    private void checkUnit(int purchaseAmount) {
        if (canDivideByThousand(purchaseAmount)) {
            return;
        }
        OutputView.printErrorMessage(ErrorMessage.ENTER_THOUSAND);
    }

    private boolean canDivideByThousand(int purchaseAmount) {
        return purchaseAmount % 1000 == 0;
    }


}
