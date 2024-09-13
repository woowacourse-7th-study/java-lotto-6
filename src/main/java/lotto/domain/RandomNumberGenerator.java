package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
    private final static int NUMBER_START = 1;
    private final static int NUMBER_END = 45;
    private final static int NUMBER_COUNT = 6;

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(NUMBER_START, NUMBER_END, NUMBER_COUNT)); // 변경 가능한 리스트로 변환
        Collections.sort(numbers);  // 정렬
        return numbers;
    }
}
