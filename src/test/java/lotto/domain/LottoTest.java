package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import lotto.constant.exception.LottoException;
import lotto.domain.model.Lotto;

class LottoTest {

    @Test
    @DisplayName("랜덤 로또 번호 생성 테스트")
    void createRandomLotto() {
        // when
        Lotto lotto = Lotto.create();

        // then
        assertThat(lotto.getLottoNumbers()).hasSize(6);
        assertThat(lotto.getLottoNumbers())
                .allMatch(number -> number >= 1 && number <= 45);
    }

    @Test
    @DisplayName("중복된 번호 예외 테스트")
    void createLottoWithDuplicatedNumbers() {
        // when & then
        assertThatThrownBy(() -> Lotto.create("1,2,3,4,5,5"))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining("[ERROR] 중복되는 수를 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("번호 개수 불일치 예외 테스트")
    void createLottoWithInvalidLength() {
        // when & then
        assertThatThrownBy(() -> Lotto.create("1,2,3,4"))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
    }

    @Test
    @DisplayName("범위 벗어난 번호 예외 테스트")
    void createLottoWithOutOfRangeNumbers() {
        // when & then
        assertThatThrownBy(() -> Lotto.create("1,2,3,4,5,50"))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining("[ERROR] 1부터 45의 숫자만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("정상적인 로또 생성 테스트")
    void createLottoWithValidNumbers() {
        // given
        String validInput = "1,2,3,4,5,6";

        // when
        Lotto lotto = Lotto.create(validInput);

        // then
        assertThat(lotto.getLottoNumbers())
                .hasSize(6)
                .containsExactly(1, 2, 3, 4, 5, 6);
    }
}
