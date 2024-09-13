package lotto.dto;

import lotto.model.BonusNumber;

public record BonusNumberDto(Integer bonusNumber) {
    public BonusNumberDto(BonusNumber bonusNumber) {
        this(bonusNumber.getBonusNumber());
    }
}