package lotto.model;

import static lotto.constants.ErrorMessage.ENTER_NUMBER_IN_RANGE;
import static lotto.constants.Number.RANGE_END;
import static lotto.constants.Number.RANGE_START;

public class BonusNumber {
    private final Integer bonusNumber;

    public BonusNumber(final Integer bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(final Integer bonusNumber) {
        validateRange(bonusNumber);
    }

    private void validateRange(final Integer bonusNumber) {
        if (bonusNumber < RANGE_START.getValue() || bonusNumber > RANGE_END.getValue()) {
            throw new IllegalArgumentException(ENTER_NUMBER_IN_RANGE.toString());
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
