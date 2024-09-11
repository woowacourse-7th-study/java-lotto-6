package lotto.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.Number.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize();
        validateRange();
        validateDuplication();
    }

    private void validateSize() {
        if (numbers.size() != MAX_COUNT.getValue()) {
            throw new IllegalArgumentException(ENTER_SIX_NUMBERS.toString());
        }
    }

    private void validateRange() {
        numbers.forEach(number -> {
            if (number < RANGE_START.getValue() || number > RANGE_END.getValue()) {
                throw new IllegalArgumentException(ENTER_NUMBER_IN_RANGE.toString());
            }
        });
    }

    private void validateDuplication() {
        Set<Integer> after = new HashSet<>(numbers);
        if (numbers.size() == after.size()) {
            return;
        }
        throw new IllegalArgumentException(ENTER_NUMBERS_NOT_DUPLICATED.toString());
    }
}
