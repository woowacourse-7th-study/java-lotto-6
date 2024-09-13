package lotto.dto;

import lotto.model.PurchasePrice;

public record PurchasePriceDto(Integer quantity) {
    public PurchasePriceDto(PurchasePrice purchasePrice) {
        this(purchasePrice.getQuantity());
    }
}
