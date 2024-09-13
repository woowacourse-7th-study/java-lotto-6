package lotto.domain.dto;

import java.util.List;

public record CountData(List<Integer> lottoNumbers, List<Integer> winningNumbers, BonusNumberData bonusNumberData, Integer[] winningLottoCounts) {
}
