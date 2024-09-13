package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import lotto.constant.exception.LottoException;
import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningLotto;

import java.util.List;

class WinningLottoTest {

    @Test
    @DisplayName("Lotto와 BonusNumber가 중복되지 않으면 WinningLotto가 생성된다.")
    void createWinningLotto() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        // when
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        // then
        assertThat(winningLotto.getLottoNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.hasSameNumber(lotto)).isFalse();
    }

    @Test
    @DisplayName("Lotto와 BonusNumber가 중복되면 예외 발생")
    void duplicateNumberThrowsException() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(6);

        // when & then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining("[ERROR] 중복되는 수를 입력할 수 없습니다.");
    }
    
    @Test
    @DisplayName("WinningLotto의 Lotto 번호 가져오기")
    void getLottoNumbers() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        // when
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        // then
        assertThat(winningLotto.getLottoNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
