package lotto.service;

import lotto.domain.dto.WinningNumbersDto;
import lotto.domain.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static lotto.constant.ErrorMessage.ENTER_INTEGER;
import static lotto.constant.ErrorMessage.ENTER_NUMBERS_WITH_COMMA;
import static lotto.constant.ErrorMessage.NOT_ALLOWED_WHITESPACE;

public class WinningNumbersService {
    private final String COMMA = ",";

    public WinningNumbersDto inputWinningNumbers() {
        return validWinningNumbers();
    }

    private WinningNumbersDto validWinningNumbers() {
        while (true) {
            try {
                return attemptInputWinningNumbers();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningNumbersDto attemptInputWinningNumbers() {
        String input = InputView.inputWinningNumbers();
        validateStrip(input);
        validateComma(input);
        String[] numbers = input.split(COMMA);
        validateInteger(numbers);
        List<Integer> sortedNumbers = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();

        WinningNumbers winningNumbers = new WinningNumbers(sortedNumbers);
        return new WinningNumbersDto(winningNumbers);
    }

    private void validateStrip(final String input) {
        String stripped = input.strip();
        if (input.equals(stripped)) {
            return;
        }
        throw new IllegalArgumentException(NOT_ALLOWED_WHITESPACE.toString());
    }

    private void validateComma(final String input) {
        if (input.contains(COMMA)) {
            return;
        }
        throw new IllegalArgumentException(ENTER_NUMBERS_WITH_COMMA.toString());
    }

    private void validateInteger(final String[] numbers) {
        try {
            Arrays.stream(numbers)
                    .forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ENTER_INTEGER.toString());
        }
    }
}