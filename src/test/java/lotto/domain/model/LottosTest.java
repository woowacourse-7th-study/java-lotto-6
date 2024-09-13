package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @DisplayName("size 메서드를 통해 포함된 로또의 개수를 가져올 수 있다.")
    @Test
    void getCountOfLotto() {
        // given
        Lottos lottos = new Lottos();
        int expected = 0;

        // when
        int real = lottos.size();

        // then
        assertThat(real).isEqualTo(expected);
    }

    @DisplayName("addLotto 메서드를 통해 로또를 추가할 수 있다.")
    @Test
    void addLotto() {
        // given
        Lottos lottos = new Lottos();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        int expected = 1;

        // when
        lottos.addLotto(lotto);
        int real = lottos.size();

        // then
        assertThat(real).isEqualTo(expected);
    }

    @DisplayName("getLottos 메서드를 통해 포함된 로또들을 가져올 수 있다")
    @Test
    void getLottos() {
        // given
        Lottos lottos = new Lottos();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto expected = new Lotto(numbers);
        lottos.addLotto(expected);

        // when
        List<Lotto> real = lottos.getLottos();

        // then
        assertThat(real).containsExactly(expected);
    }
}