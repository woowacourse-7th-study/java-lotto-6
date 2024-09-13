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
        UserInputValidator.validateStrip(input);
        UserInputValidator.validateComma(input);
        String[] numbers = input.split(COMMA.toString());
        UserInputValidator.validateInteger(numbers);
        List<Integer> sortedNumbers = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();

        WinningNumbers winningNumbers = new WinningNumbers(sortedNumbers);
        return new WinningNumbersDto(winningNumbers);
    }
}