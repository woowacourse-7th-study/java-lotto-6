package lotto.service;

import lotto.dto.BonusNumberDto;
import lotto.model.BonusNumber;
import lotto.validator.UserInputValidator;
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
        UserInputValidator.validateStrip(input);
        UserInputValidator.validateInteger(input);
        Integer number = Integer.parseInt(input);
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ENTER_BONUS_NUMBER_NOT_DUPLICATED.toString());
        }
        BonusNumber bonusNumber = new BonusNumber(number);
        return new BonusNumberDto(bonusNumber);
    }
}