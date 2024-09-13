package lotto.domain.dto;

import lotto.domain.model.Lottos;

public record InputDto(Lottos lottos, WinningNumbersDto winningNumbersDto, BonusNumberDto bonusNumberDto) {
}
