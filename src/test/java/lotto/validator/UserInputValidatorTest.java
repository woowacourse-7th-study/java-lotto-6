package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constants.ErrorMessage.ENTER_BONUS_NUMBER_NOT_DUPLICATED;
import static lotto.constants.ErrorMessage.ENTER_INTEGER;
import static lotto.constants.ErrorMessage.ENTER_NUMBERS_WITH_COMMA;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_BLANK;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_WHITESPACE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputValidatorTest {
    @DisplayName("빈 문자열을 입력하는 경우 예외가 발생한다.")
    @Test
    void validateBlank() {
        // given
        String input = "   ";

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALLOWED_BLANK.toString());
    }

    @DisplayName("문자열 맨 앞, 맨 뒤에 공백이 포함되는 경우 예외가 발생한다.")
    @Test
    void validateStrip() {
        // given
        String input = " 1,2,3,4,5,6 ";

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateStrip(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALLOWED_WHITESPACE.toString());
    }

    @DisplayName("문자열에 ','가 포함되지 않는 경우 예외가 발생한다.")
    @Test
    void validateComma() {
        // given
        String input = "123456";

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateComma(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ENTER_NUMBERS_WITH_COMMA.toString());
    }

    @DisplayName("정수가 아닌 다른 문자열이 입력되는 경우 예외가 발생한다.")
    @Test
    void validateInteger() {
        // given
        String input = "abc";

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ENTER_INTEGER.toString());
    }

    @DisplayName("정수 배열이 아닌 다른 문자열이 입력되는 경우 예외가 발생한다.")
    @Test
    void ValidateIntegerArray() {
        // given
        String[] input = new String[]{ "a", "2", "3", "4", "5", "6" };

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ENTER_INTEGER.toString());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우 예외가 발생한다.")
    @Test
    void validateDuplication() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateDuplication(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ENTER_BONUS_NUMBER_NOT_DUPLICATED.toString());
    }
}