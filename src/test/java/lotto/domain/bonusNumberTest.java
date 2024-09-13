package lotto.domain;

import lotto.constant.exception.LottoException;
import lotto.domain.model.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class bonusNumberTest {
    @Test
    @DisplayName("보너스 번호가 유효한 범위 내에 있으면 정상적으로 생성된다.")
    void validBonusNumber() {
        // given
        int validNumber = 7;

        // when
        BonusNumber bonusNumber = new BonusNumber(validNumber);

        // then
        assertThat(bonusNumber.getNumber()).isEqualTo(validNumber);
    }

    @Test
    @DisplayName("보너스 번호가 최소값보다 작으면 예외가 발생한다.")
    void bonusNumberMinThrowsException() {
        // given
        int invalidNumber = 0;

        // when & then
        assertThatThrownBy(() -> new BonusNumber(invalidNumber))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining("[ERROR] " + "1부터 45의 숫자만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 최대값보다 크면 예외가 발생한다.")
    void bonusNumberMaxThrowsException() {
        // given
        int invalidNumber = 46;

        // when & then
        assertThatThrownBy(() -> new BonusNumber(invalidNumber))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining("[ERROR] " + "1부터 45의 숫자만 입력할 수 있습니다.");
    }
}
