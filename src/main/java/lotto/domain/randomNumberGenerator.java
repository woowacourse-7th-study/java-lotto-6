package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class randomNumberGenerator {
    private final static int NUMBER_START = 1;
    private final static int NUMBER_END = 45;
    private final static int NUMBER_COUNT = 6;

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(NUMBER_START, NUMBER_END, NUMBER_COUNT);
        Collections.sort(numbers);
        return numbers;
    }
}