package lotto.factory;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.List;

import static lotto.constants.Number.MAX_COUNT;
import static lotto.constants.Number.RANGE_END;
import static lotto.constants.Number.RANGE_START;

public class LottoFactory {
    private LottoFactory() {
    }

    public static Lotto issueLotto() {
        List<Integer> numbers = createNumbers();
        return new Lotto(numbers);
    }

    private static List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(RANGE_START.getValue(),
                RANGE_END.getValue(),
                MAX_COUNT.getValue());
    }
}
