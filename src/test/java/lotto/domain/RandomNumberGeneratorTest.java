package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import lotto.domain.RandomNumberGenerator;

import java.util.List;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("랜덤 번호가 생성될 때 자동으로 정렬된다.")
    void givenRandomNumbersSorted() {

        // when
        List<Integer> generatedNumbers = RandomNumberGenerator.generateNumbers();

        // then
        assertThat(generatedNumbers)
                .isSorted() // 정렬되었는지
                .hasSize(6)
                .allMatch(number -> number >= 1 && number <= 45);
    }
}
