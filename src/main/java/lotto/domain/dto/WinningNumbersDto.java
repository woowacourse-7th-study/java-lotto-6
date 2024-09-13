package lotto.domain.dto;

import lotto.domain.model.WinningNumbers;

import java.util.List;

public record WinningNumbersDto(List<Integer> winningNumbers) {
    public WinningNumbersDto(WinningNumbers winningNumbers) {
        this(winningNumbers.getWinningNumbers());
    }
}
