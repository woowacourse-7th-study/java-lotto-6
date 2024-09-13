package lotto.dto;

import java.util.List;

public record CountDto(List<Integer> lottoNumbers, List<Integer> winningNumbers, BonusNumberDto bonusNumberDto, Integer[] winningLottoCounts) {
}
