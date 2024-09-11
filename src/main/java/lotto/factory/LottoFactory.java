package lotto.factory;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.model.Lotto;

import java.util.List;

import static lotto.constant.Number.*;

public class LottoFactory {
    public Lotto issueLotto() {
        List<Integer> numbers = createNumbers();
        return new Lotto(numbers);
    }

    private List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(RANGE_START.getValue(), RANGE_END.getValue(), MAX_COUNT.getValue());
    }
}
