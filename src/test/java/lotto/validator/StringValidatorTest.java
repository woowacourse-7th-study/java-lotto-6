package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constant.exception.error.ErrorMessage.INVALID_PRICE_INTEGER;
import static org.assertj.core.api.Assertions.*;
import lotto.constant.exception.LottoException;

class StringValidatorTest {

    @Test
    @DisplayName("문자열이 정수로 변환되면 예외가 발생하지 않는다.")
    void validStringToInteger() {
        // given
        String validInput = "1234";

        // when & then
        assertThatCode(() -> StringValidator.validateStringToInteger(validInput))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("문자열이 정수로 변환되지 않으면 예외가 발생한다.")
    void invalidStringThrowsException() {
        // given
        String invalidInput = "abc";

        // when & then
        assertThatThrownBy(() -> StringValidator.validateStringToInteger(invalidInput))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_PRICE_INTEGER.getMessage());
    }

    @Test
    @DisplayName("빈 문자열 입력시 예외가 발생한다.")
    void emptyStringThrowsException() {
        // given
        String emptyInput = "";

        // when & then
        assertThatThrownBy(() -> StringValidator.validateStringToInteger(emptyInput))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_PRICE_INTEGER.getMessage());
    }

    @Test
    @DisplayName("공백이 포함된 문자열 입력시 예외가 발생한다.")
    void stringWithSpacesThrowsException() {
        // given
        String invalidInput = " 1234 ";

        // when & then
        assertThatThrownBy(() -> StringValidator.validateStringToInteger(invalidInput))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_PRICE_INTEGER.getMessage());
    }
}
