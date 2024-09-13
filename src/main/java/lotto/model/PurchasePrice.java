package lotto.model;

import static lotto.constants.ErrorMessage.ENTER_THOUSAND;
import static lotto.constants.Number.UNIT;

public class PurchasePrice {
    private final Integer purchasePrice;

    public PurchasePrice(final Integer purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validate(final Integer purchasePrice) {
        checkUnit(purchasePrice);
    }

    private void checkUnit(final Integer purchasePrice) {
        if (canDivideByThousand(purchasePrice)) {
            return;
        }
        throw new IllegalArgumentException(ENTER_THOUSAND.toString());
    }

    private boolean canDivideByThousand(final Integer purchasePrice) {
        return purchasePrice % UNIT.getValue() == 0;
    }

    public Integer getQuantity() {
        return purchasePrice / UNIT.getValue();
    }
}
