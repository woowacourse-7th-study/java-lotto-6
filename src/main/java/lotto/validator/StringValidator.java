package lotto.validator;

import lotto.constant.exception.LottoException;

import static lotto.constant.exception.error.ErrorMessage.INVALID_PRICE_INTEGER;

public class StringValidator {
    public static void validateStringToInteger(String input) { // 문자열-> 숫자 검증 과정
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoException(INVALID_PRICE_INTEGER);
        }
    }
}
