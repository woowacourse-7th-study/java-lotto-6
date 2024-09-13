package lotto.domain.dto;

import lotto.domain.model.BonusNumber;

public record BonusNumberDto(Integer bonusNumber) {
    public BonusNumberDto(BonusNumber bonusNumber) {
        this(bonusNumber.getBonusNumber());
    }
}