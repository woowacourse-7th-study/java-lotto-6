package lotto.domain.dto;

import lotto.domain.model.Lottos;

public record InputData(Lottos lottos, WinningNumbersData winningNumbersData, BonusNumberData bonusNumberData) {
}
