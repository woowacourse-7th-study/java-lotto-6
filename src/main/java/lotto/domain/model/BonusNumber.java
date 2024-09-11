package lotto.domain.model;

import lotto.constant.exception.LottoException;

import static lotto.constant.LottoConfig.RANGE_MAX;
import static lotto.constant.LottoConfig.RANGE_MIN;
import static lotto.constant.exception.error.ErrorMessage.OUT_OF_RANGE;

public class BonusNumber {
    private final Integer number;

    public BonusNumber(int number){
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number){ // 범위를 벗어나는 숫자인지 검증
        if(isNotRequiredRange(number)){
            throw new LottoException(OUT_OF_RANGE);
        }
    }

    private boolean isNotRequiredRange(int number) {
        return number < RANGE_MIN.getValue() || number > RANGE_MAX.getValue();
    }

    public int getNumber() {
        return number;
    }
}
