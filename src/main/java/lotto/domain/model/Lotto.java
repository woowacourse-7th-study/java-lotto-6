package lotto.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.ErrorMessage.ENTER_NUMBERS_NOT_DUPLICATED;
import static lotto.constant.ErrorMessage.ENTER_NUMBER_IN_RANGE;
import static lotto.constant.ErrorMessage.ENTER_SIX_NUMBERS;
import static lotto.constant.Number.MAX_COUNT;
import static lotto.constant.Number.RANGE_END;
import static lotto.constant.Number.RANGE_START;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != MAX_COUNT.getValue()) {
            throw new IllegalArgumentException(ENTER_SIX_NUMBERS.toString());
        }
    }

    private void validateDuplication(final List<Integer> numbers) {
        Set<Integer> after = new HashSet<>(numbers);
        if (numbers.size() == after.size()) {
            return;
        }
        throw new IllegalArgumentException(ENTER_NUMBERS_NOT_DUPLICATED.toString());
    }

    private void validateRange(final List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < RANGE_START.getValue() || number > RANGE_END.getValue()) {
                throw new IllegalArgumentException(ENTER_NUMBER_IN_RANGE.toString());
            }
        });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return String.join(", ", numbers.toString());
    }
}
