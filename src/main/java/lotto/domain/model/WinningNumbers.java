package lotto.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.Number.*;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(final List<Integer> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validate(final List<Integer> winningNumbers) {
        validateSize(winningNumbers);
        validateRange(winningNumbers);
        validateDuplication(winningNumbers);
    }

    private void validateSize(final List<Integer> winningNumbers) {
        if (winningNumbers.size() == MAX_COUNT.getValue()) {
            return;
        }
        throw new IllegalArgumentException(ENTER_SIX_NUMBERS.toString());
    }

    private void validateRange(final List<Integer> winningNumbers) {
        winningNumbers.forEach(winningNumber -> {
            if (winningNumber < RANGE_START.getValue()
                    || winningNumber > RANGE_END.getValue()) {
                throw new IllegalArgumentException(ENTER_NUMBER_IN_RANGE.toString());
            }
        });
    }

    private void validateDuplication(final List<Integer> winningNumbers) {
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