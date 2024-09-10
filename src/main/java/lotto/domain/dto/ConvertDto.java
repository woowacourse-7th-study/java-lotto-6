package lotto.domain.dto;

import lotto.domain.validator.inputPriceValidator;

import static lotto.constant.ErrorMessage.INVALID_PRICE_INTEGER;

public class ConvertDto {
    private static final int TICKET_PRICE = 1000;

    public static Integer priceToTicket(String input){ // 입력받은 금액을 티켓의 갯수로 변환
        int intPrice =  stringToInteger(input);
        inputPriceValidator.validateInteger(intPrice); // 예외 처리
        return stringToInteger(input) / TICKET_PRICE;
    }

    private static Integer stringToInteger(String input){ // 입력받은 String 문자열을 Integer 타입으로 변경
        inputPriceValidator.validateStringToInteger(input); // 정수로 들어온 값인지 검증
        return Integer.parseInt(input);
    }
}
