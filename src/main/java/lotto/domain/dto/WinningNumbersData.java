package lotto.domain.dto;

import lotto.domain.model.WinningNumbers;

import java.util.List;

public record WinningNumbersData(List<Integer> winningNumbers) {
    public WinningNumbersData(WinningNumbers winningNumbers) {
        this(winningNumbers.getWinningNumbers());
    }
}
