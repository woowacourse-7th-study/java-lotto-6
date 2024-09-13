package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constant.ErrorMessage.ENTER_NUMBER_IN_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @DisplayName("보너스 번호가 1에서 45 사이의 정수가 아닌 경우 예외가 발생한다.")
    @Test
    void createBonusNumberByOverRange() {
        // given
        int number = 0;

        // when & then
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ENTER_NUMBER_IN_RANGE.toString());
    }

    @DisplayName("getter 메서드를 통해 보너스 번호를 받아올 수 있다.")
    @Test
    void getBonusNumber() {
        // given
        int expected = 5;
        BonusNumber bonusNumber = new BonusNumber(expected);

        // when
        int real = bonusNumber.getBonusNumber();

        // then
        assertThat(real).isEqualTo(expected);
    }
}