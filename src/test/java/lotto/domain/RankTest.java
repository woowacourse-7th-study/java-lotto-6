package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import lotto.domain.model.Rank;

class RankTest {

    @Test
    @DisplayName("6개 일치하면 1등이어야 한다.")
    void firstRank() {
        // given
        int matchNumber = 6;
        boolean hasBonus = false;

        // when
        Rank rank = Rank.matchLottoRank(matchNumber, hasBonus);

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
        assertThat(rank.getPrize()).isEqualTo(2_000_000_000);
    }

    @Test
    @DisplayName("5개 일치하고 보너스 번호가 일치하면 2등이어야 한다.")
    void secondRankWithBonus() {
        // given
        int matchNumber = 5;
        boolean hasBonus = true;

        // when
        Rank rank = Rank.matchLottoRank(matchNumber, hasBonus);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
        assertThat(rank.getPrize()).isEqualTo(30_000_000);
    }

    @Test
    @DisplayName("5개 일치하고 보너스 번호가 일치하지 않으면 3등이어야 한다.")
    void thirdRankWithoutBonus() {
        // given
        int matchNumber = 5;
        boolean hasBonus = false;

        // when
        Rank rank = Rank.matchLottoRank(matchNumber, hasBonus);

        // then
        assertThat(rank).isEqualTo(Rank.THIRD);
        assertThat(rank.getPrize()).isEqualTo(1_500_000);
    }

    @Test
    @DisplayName("4개 일치하면 4등이어야 한다.")
    void fourthRank() {
        // given
        int matchNumber = 4;
        boolean hasBonus = false;

        // when
        Rank rank = Rank.matchLottoRank(matchNumber, hasBonus);

        // then
        assertThat(rank).isEqualTo(Rank.FIRTH);
        assertThat(rank.getPrize()).isEqualTo(50_000);
    }

    @Test
    @DisplayName("3개 일치하면 5등이어야 한다.")
    void fifthRank() {
        // given
        int matchNumber = 3;
        boolean hasBonus = false;

        // when
        Rank rank = Rank.matchLottoRank(matchNumber, hasBonus);

        // then
        assertThat(rank).isEqualTo(Rank.FIFTH);
        assertThat(rank.getPrize()).isEqualTo(5_000);
    }

    @Test
    @DisplayName("2개 이하 일치하면 NONE이어야 한다.")
    void noRank() {
        // given
        int matchNumber = 2;
        boolean hasBonus = false;

        // when
        Rank rank = Rank.matchLottoRank(matchNumber, hasBonus);

        // then
        assertThat(rank).isEqualTo(Rank.NONE);
        assertThat(rank.getPrize()).isEqualTo(0);
    }
}
