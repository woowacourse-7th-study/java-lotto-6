package lotto.service;

import lotto.constant.ErrorMessage;
import lotto.domain.dto.WinningNumbersData;
import lotto.domain.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class WinningNumbersService {
    private final String COMMA = ",";

    public WinningNumbersData inputWinningNumbers() {
        return validWinningNumbers();
    }

    private WinningNumbersData validWinningNumbers() {
        while (true) {
            try {
                return attemptInputWinningNumbers();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningNumbersData attemptInputWinningNumbers() {
        String input = InputView.inputWinningNumbers();
        validateStrip(input);
        validateComma(input);
        String[] numbers = input.split(COMMA);
        validateInteger(numbers);
        List<Integer> sortedNumbers = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .sorted()
                .toList();

        WinningNumbers winningNumbers = new WinningNumbers(sortedNumbers);
        return new WinningNumbersData(winningNumbers);
    }

    private void validateStrip(final String input) {
        String stripped = input.strip();
        if (input.equals(stripped)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_ALLOWED_WHITESPACE.toString());
    }

    private void validateComma(final String input) {
        if (input.contains(COMMA)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.ENTER_NUMBERS_WITH_COMMA.toString());
    }

    private void validateInteger(final String[] numbers) {
        try {
            Arrays.stream(numbers)
                    .forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_INTEGER.toString());
        }
    }

}