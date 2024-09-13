package lotto.service;

import lotto.domain.model.Lotto;
import lotto.domain.model.WinningLotto;

import java.util.List;

public class MatchNumberService {

    public static int getMatchNumber(WinningLotto winningLotto, Lotto randomLotto) { // 일치하는 숫자 개수 반환
        List<Integer> winningNumbers = winningLotto.getLottoNumbers();
        List<Integer> myNumbers = randomLotto.getLottoNumbers();

        return (int) myNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
