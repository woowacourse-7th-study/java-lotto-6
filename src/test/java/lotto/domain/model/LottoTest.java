package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.ErrorMessage.ENTER_NUMBERS_NOT_DUPLICATED;
import static lotto.constant.ErrorMessage.ENTER_NUMBER_IN_RANGE;
import static lotto.constant.ErrorMessage.ENTER_SIX_NUMBERS;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ENTER_SIX_NUMBERS.toString());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ENTER_NUMBERS_NOT_DUPLICATED.toString());
    }

    @DisplayName("로또 번호가 1에서 45 사이의 정수가 아닌 경우 예외가 발생한다.")
    @Test
    void createdLottoByOverRange() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(46, 1, 2, 3, 4, 5));
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ENTER_NUMBER_IN_RANGE.toString());
    }
}