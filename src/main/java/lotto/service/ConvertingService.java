package lotto.service;

import lotto.validator.InputPriceValidator;
import lotto.validator.StringValidator;

import static lotto.constant.LottoConfig.PRICE_UNIT;

public class ConvertingService {

    public static Integer priceToTicket(String input) { // 입력받은 금액을 티켓의 갯수로 변환
        int intPrice = stringToInteger(input);
        InputPriceValidator.validateInteger(intPrice); // 예외 처리
        return stringToInteger(input) / PRICE_UNIT.getValue();
    }

    public static Integer stringToInteger(String input) { // 입력받은 String 문자열을 Integer 타입으로 변경
        StringValidator.validateStringToInteger(input); // 정수로 들어온 값인지 검증
        return Integer.parseInt(input);
    }
}
