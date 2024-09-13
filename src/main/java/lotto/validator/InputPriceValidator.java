package lotto.validator;

import lotto.constant.exception.LottoException;

import static lotto.constant.exception.error.ErrorMessage.INVALID_PRICE_MIN;
import static lotto.constant.exception.error.ErrorMessage.INVALID_PRICE_UNIT;
import static lotto.constant.exception.error.ErrorMessage.INVALID_PRICE_INTEGER;

public class InputPriceValidator {
    private static final int PRICE_UNIT = 1000;
    private static final int PRICE_MIN = 1000;

    public static void validateInteger(int price){
        validateMin(price);
        validateUnit(price);
    }

    private static void validateMin(int price){ // 최소 금액은 1000원이어야 한다.
        if(price < PRICE_MIN){
            throw new LottoException(INVALID_PRICE_MIN);
        }
    }
    private static void validateUnit(int price){ // 1000원으로 나누어 떨어져야 한다.
        if(price % PRICE_UNIT != 0){
            throw new LottoException(INVALID_PRICE_UNIT);
        }
    }


}
