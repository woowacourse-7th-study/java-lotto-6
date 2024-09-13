package lotto.domain.dto;

import lotto.domain.model.PurchasePrice;

public record PurchasePriceDto(Integer quantity) {
    public PurchasePriceDto(PurchasePrice purchasePrice) {
        this(purchasePrice.getQuantity());
    }
}
