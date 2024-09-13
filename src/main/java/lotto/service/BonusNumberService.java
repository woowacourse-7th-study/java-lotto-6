package lotto.service;

import lotto.constant.ErrorMessage;
import lotto.domain.dto.BonusNumberData;
import lotto.domain.model.BonusNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.constant.ErrorMessage.ENTER_BONUS_NUMBER_NOT_DUPLICATED;

public class BonusNumberService {
    private final List<Integer> winningNumbers;

    public BonusNumberService(final List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public BonusNumberData inputBonusNumber() {
        return validBonusNumber();
    }

    private BonusNumberData validBonusNumber() {
        while (true) {
            try {
                return attemptInputBonusNumber();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private BonusNumberData attemptInputBonusNumber() {
        String input = InputView.inputBonusNumber();
        validateStrip(input);
        validateInteger(input);
        Integer number = Integer.parseInt(input);
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ENTER_BONUS_NUMBER_NOT_DUPLICATED.toString());
        }
        BonusNumber bonusNumber = new BonusNumber(number);
        return new BonusNumberData(bonusNumber);
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