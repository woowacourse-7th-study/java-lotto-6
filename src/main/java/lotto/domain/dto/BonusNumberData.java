package lotto.domain.dto;

import lotto.domain.model.BonusNumber;

public record BonusNumberData(Integer bonusNumber) {
    public BonusNumberData(BonusNumber bonusNumber) {
        this(bonusNumber.getBonusNumber());
    }
}