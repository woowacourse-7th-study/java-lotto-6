package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.ErrorMessage.ENTER_NUMBERS_NOT_DUPLICATED;
import static lotto.constant.ErrorMessage.ENTER_NUMBER_IN_RANGE;
import static lotto.constant.ErrorMessage.ENTER_SIX_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @DisplayName("추첨 번호의 개수가 6개 이상인 경우 예외가 발생한다.")
    @Test
    void createWinningNumbersByOverSize() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));

        // when & then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ENTER_SIX_NUMBERS.toString());
    }

    @DisplayName("추첨 번호에 중복이 있는 경우 예외가 발생한다.")
    @Test
    void createWinningNumbersByDuplicatedNumber() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));

        // when & then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ENTER_NUMBERS_NOT_DUPLICATED.toString());
    }

    @DisplayName("추첨 번호가 1에서 45 사이의 정수가 아닌 경우 예외가 발생한다.")
    @Test
    void createWinningNumbersByOverRange() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(46, 1, 2, 3, 4, 5));

        // when & then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ENTER_NUMBER_IN_RANGE.toString());
    }

    @DisplayName("getter 메서드를 통해 추첨 번호를 가져올 수 있다.")
    @Test
    void getWinningNumbers() {
        // given
        List<Integer> expected = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(expected);

        // when
        List<Integer> real = winningNumbers.getWinningNumbers();

        // then
        assertThat(real).isEqualTo(expected);
    }
}