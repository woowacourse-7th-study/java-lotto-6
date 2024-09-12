package lotto.domain.model;

import lotto.constant.Number;

import static lotto.constant.ErrorMessage.ENTER_THOUSAND;

public class PurchasePrice {
    private final Integer UNIT = 1000;

    private final Integer purchasePrice;

    public PurchasePrice(Integer purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validate(Integer purchasePrice) {
        checkUnit(purchasePrice);
    }

    private void checkUnit(final Integer purchasePrice) {
        if (canDivideByThousand(purchasePrice)) {
            return;
        }
        throw new IllegalArgumentException(ENTER_THOUSAND.toString());
    }

    private boolean canDivideByThousand(final Integer purchasePrice) {
        return purchasePrice % Number.UNIT.getValue() == 0;
    }

    public Integer getQuantity() {
        return purchasePrice / Number.UNIT.getValue();
    }
}
