package lotto.dto;

import lotto.model.Lottos;

public record InputDto(Lottos lottos, WinningNumbersDto winningNumbersDto, BonusNumberDto bonusNumberDto) {
}
