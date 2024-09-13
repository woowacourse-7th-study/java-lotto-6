package lotto.service;

import lotto.dto.WinningNumbersDto;
import lotto.model.WinningNumbers;
import lotto.validator.UserInputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static lotto.constants.Symbol.COMMA;

public class WinningNumbersService {
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
        UserInputValidator.validateBlank(input);
        UserInputValidator.validateStrip(input);
        UserInputValidator.validateComma(input);
        String[] splittedInput = input.split(COMMA.toString());
        UserInputValidator.validateInteger(splittedInput);
        List<Integer> numbers = Arrays.stream(splittedInput)
                .map(Integer::parseInt)
                .toList();

        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        return new WinningNumbersDto(winningNumbers);
    }
}