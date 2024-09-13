package lotto.service;

import lotto.constant.Number;
import lotto.constant.Profit;
import lotto.domain.dto.*;
import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static lotto.constant.Number.MIN_COUNT_FOR_PRIZE;
import static lotto.constant.Number.WINNERS_COUNT;
import static lotto.constant.Ranking.FIRST;
import static lotto.constant.Ranking.THIRD;

public class ResultService {
    public void printResult(InputDto inputDto) {
        OutputView.printResultHeader();
        Integer[] winningLottoCounts = countWinningLotto(inputDto);

        Lottos lottos = inputDto.lottos();
        Double rateOfReturn = calculateRateOfReturn(lottos, winningLottoCounts);
        ResultDto resultDto = createDto(winningLottoCounts, rateOfReturn);
        OutputView.printResult(resultDto);
    }

    private Integer[] countWinningLotto(InputDto inputDto) {
        Lottos lottosInfo = inputDto.lottos();
        WinningNumbersDto winningNumbersDto = inputDto.winningNumbersDto();
        BonusNumberDto bonusNumberDto = inputDto.bonusNumberDto();

        List<Integer> winningNumbers = winningNumbersDto.winningNumbers();
        List<Lotto> lottos = lottosInfo.getLottos();

        Integer[] winningLottoCounts = new Integer[WINNERS_COUNT.getValue()];
        Arrays.fill(winningLottoCounts, 0);

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            CountDto countDto = new CountDto(lottoNumbers, winningNumbers, bonusNumberDto, winningLottoCounts);
            countSameNumber(countDto);
        }

        return winningLottoCounts;
    }

    private void countSameNumber(CountDto countDto) {
        List<Integer> lottoNumbers = countDto.lottoNumbers();
        List<Integer> winningNumbers = countDto.winningNumbers();
        BonusNumberDto bonusNumberDto = countDto.bonusNumberDto();
        Integer[] winningLottoCounts = countDto.winningLottoCounts();

        int count = calculateCount(lottoNumbers, winningNumbers);
        if (count >= MIN_COUNT_FOR_PRIZE.getValue()) {
            int index = calculateIndex(lottoNumbers, bonusNumberDto, count);
            winningLottoCounts[index]++;
        }
    }

    private int calculateCount(final List<Integer> lottoNumbers, final List<Integer> winningNumbers) {
        int count = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    /*
      rank      count       index
        5         3           0
        4         4           1
        3         5           2
        2         5 + bonus   3
        1         6           4
     */
    private int calculateIndex(final List<Integer> lottoNumbers, BonusNumberDto bonusNumberDto, final Integer count) {
        int index = count - MIN_COUNT_FOR_PRIZE.getValue();
        if (count.equals(THIRD.getNumberCount())) {
            index = countBonusNumber(bonusNumberDto, lottoNumbers);
        }
        if (count.equals(FIRST.getNumberCount())) {
            index++;
        }
        return index;
    }

    private int countBonusNumber(final BonusNumberDto bonusNumberDto, final List<Integer> lottoNumbers) {
        int bonusNumber = bonusNumberDto.bonusNumber();
        if (lottoNumbers.contains(bonusNumber)) {
            return 3;
        }
        return 2;
    }

    private Double calculateRateOfReturn(final Lottos lottos, final Integer[] winningLottoCounts) {
        Integer size = lottos.size();
        Integer purchaseAmount = size * Number.UNIT.getValue();
        Long profitAmount = calculateProfitAmount(winningLottoCounts);
        final Double rateOfReturn = (double) (profitAmount - purchaseAmount) / purchaseAmount * 100;
        return rateOfReturn;
    }

    private Long calculateProfitAmount(final Integer[] winningLottoCounts) {
        long profitAmount = 0;
        for (Profit profit : Profit.values()) {
            int index = profit.ordinal();
            profitAmount += winningLottoCounts[index] * profit.getProfit();
        }
        return profitAmount;
    }

    private ResultDto createDto(final Integer[] winningLottoCounts, final Double rateOfReturn) {
        return new ResultDto(winningLottoCounts, rateOfReturn);
    }
}
