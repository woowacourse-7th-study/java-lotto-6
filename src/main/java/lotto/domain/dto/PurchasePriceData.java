package lotto.domain.dto;

import lotto.domain.model.PurchasePrice;

public record PurchasePriceData(Integer quantity) {
    public PurchasePriceData(PurchasePrice purchasePrice) {
        this(purchasePrice.getQuantity());
    }
}
