package lotto.service;

import lotto.constants.ErrorMessage;
import lotto.dto.BonusNumberDto;
import lotto.model.BonusNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.constants.ErrorMessage.ENTER_BONUS_NUMBER_NOT_DUPLICATED;

public class BonusNumberService {
    private final List<Integer> winningNumbers;

    public BonusNumberService(final List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public BonusNumberDto inputBonusNumber() {
        return validBonusNumber();
    }

    private BonusNumberDto validBonusNumber() {
        while (true) {
            try {
                return attemptInputBonusNumber();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private BonusNumberDto attemptInputBonusNumber() {
        String input = InputView.inputBonusNumber();
        validateStrip(input);
        validateInteger(input);
        Integer number = Integer.parseInt(input);
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ENTER_BONUS_NUMBER_NOT_DUPLICATED.toString());
        }
        BonusNumber bonusNumber = new BonusNumber(number);
        return new BonusNumberDto(bonusNumber);
    }

    private void validateStrip(final String input) {
        String stripped = input.strip();
        if (input.equals(stripped)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_ALLOWED_WHITESPACE.toString());
    }

    private void validateInteger(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_INTEGER.toString());
        }
    }
}