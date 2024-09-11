package lotto.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.Number.*;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validate(List<Integer> winningNumbers) {
        validateSize(winningNumbers);
        validateRange(winningNumbers);
        validateDuplication(winningNumbers);
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() == MAX_COUNT.getValue()) {
            return;
        }
        throw new IllegalArgumentException(ENTER_SIX_NUMBERS.toString());
    }

    private void validateRange(List<Integer> winningNumbers) {
        winningNumbers.forEach(winningNumber -> {
            if (winningNumber < RANGE_START.getValue() || winningNumber > RANGE_END.getValue()) {
                throw new IllegalArgumentException(ENTER_NUMBER_IN_RANGE.toString());
            }
        });
    }

    private void validateDuplication(List<Integer> winningNumbers) {
        Set<Integer> after = new HashSet<>(winningNumbers);
        if (winningNumbers.size() == after.size()) {
            return;
        }
        throw new IllegalArgumentException(ENTER_NUMBERS_NOT_DUPLICATED.toString());
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
