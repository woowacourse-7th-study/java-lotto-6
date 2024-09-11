package lotto.domain.model;

import lotto.constant.exception.LottoException;
import lotto.domain.dto.ConvertDto;
import lotto.domain.randomNumberGenerator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static lotto.constant.LottoConfig.*;
import static lotto.constant.exception.error.ErrorMessage.*;

public class Lotto {
    private static final String DILIMITER = ",";
    private final List<Integer> numbers;

    private Lotto() { // 컴퓨터가 생성하는 로또 번호
        this.numbers = randomNumberGenerator.generateNumbers();
    }

    public Lotto(List<Integer> numbers) { // 사용자의 입력으로 받는 로또 번호
        validateLength(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    public static Lotto create() {
        return new Lotto();
    }

    public static Lotto create(String input) {
        List<Integer> numbers = Arrays.stream(input.split(DILIMITER))
                .map(ConvertDto::stringToInteger)
                .toList();

        return new Lotto(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (isValidLength(numbers)) {
            throw new LottoException(INVALID_REQUIRED_LENGTH);
        }
    }

    private boolean isValidLength(List<Integer> numbers) {
        return numbers.size() != LOTTO_COUNT.getValue();
    }

    private void validateRange(List<Integer> numbers) {
        if (isNotRequiredRange(numbers)) {
            throw new LottoException(OUT_OF_RANGE);
        }
    }
    private boolean isNotRequiredRange(List<Integer> numbers){
        return numbers.stream()
                .anyMatch(number -> number < RANGE_MIN.getValue() || number > RANGE_MAX.getValue());
    }

    private void validateDuplication(List<Integer> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new LottoException(INVALID_DUPLICATION);
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.size() != new HashSet<Integer>(numbers).size();
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
