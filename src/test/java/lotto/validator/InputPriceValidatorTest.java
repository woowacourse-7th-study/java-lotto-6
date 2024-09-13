package lotto.validator;

import lotto.constant.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constant.exception.error.ErrorMessage.INVALID_PRICE_MIN;
import static lotto.constant.exception.error.ErrorMessage.INVALID_PRICE_UNIT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputPriceValidatorTest {
    @Test
    @DisplayName("1000원 이상일 때 금액이 유효하다.")
    void validPrice() {
        // given
        int validPrice = 3000;

        // when & then
        assertThatCode(() -> InputPriceValidator.validateInteger(validPrice))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("금액이 1000원 미만이면 예외가 발생한다.")
    void priceBelowMinimumThrowsException() {
        // given
        int invalidPrice = 500;

        // when & then
        assertThatThrownBy(() -> InputPriceValidator.validateInteger(invalidPrice))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_PRICE_MIN.getMessage());
    }

    @Test
    @DisplayName("금액이 1000원 단위가 아니면 예외가 발생한다.")
    void priceNotInUnitThrowsException() {
        // given
        int invalidPrice = 1500;

        // when & then
        assertThatThrownBy(() -> InputPriceValidator.validateInteger(invalidPrice))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_PRICE_UNIT.getMessage());
    }

    @Test
    @DisplayName("1000원 단위로 입력되면 금액이 유효하다.")
    void priceInUnit() {
        // given
        int validPrice = 4000;

        // when & then
        assertThatCode(() -> InputPriceValidator.validateInteger(validPrice))
                .doesNotThrowAnyException();
    }
}
