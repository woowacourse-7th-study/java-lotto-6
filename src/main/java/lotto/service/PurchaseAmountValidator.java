package lotto.service;

import lotto.exception.ErrorCode;
import lotto.exception.ErrorMessage;

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
            String errorMessage = addPrefix(ErrorMessage.ENTER_INTEGER);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void checkUnit(int purchaseAmount) {
        if (canDivideByThousand(purchaseAmount)) {
            return;
        }
        String errorMessage = addPrefix(ErrorMessage.ENTER_THOUSAND);
        throw new IllegalArgumentException(errorMessage);
    }

    private boolean canDivideByThousand(int purchaseAmount) {
        return purchaseAmount % 1000 == 0;
    }

    private String addPrefix(ErrorMessage errorMessage) {
        return String.format("%s %s", ErrorCode.PREFIX, errorMessage);
    }
}
