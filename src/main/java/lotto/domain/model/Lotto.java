package lotto.domain.model;

import lotto.domain.randomNumberGenerator;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(){ // 컴퓨터가 생성하는 로또 번호
        this.numbers = randomNumberGenerator.generateNumbers();
    }
    public Lotto(List<Integer> numbers) { // 사용자의 입력으로 받는 로또 번호
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto create(){
        return new Lotto();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLottoNumbers(){
        return numbers;
    }
}
