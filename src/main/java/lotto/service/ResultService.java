package lotto.service;

import lotto.constant.Number;
import lotto.constant.Profit;
import lotto.domain.dto.BonusNumberData;
import lotto.domain.dto.ResultData;
import lotto.domain.dto.WinningNumbersData;
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
    public void printResult(final Lottos lottos, final WinningNumbersData winningNumbersData, final BonusNumberData bonusNumberData) {
        OutputView.printResultHeader();
        Integer[] winningLottoCounts = countWinningLotto(lottos, winningNumbersData, bonusNumberData);
        Double rateOfReturn = calculateRateOfReturn(lottos, winningLottoCounts);
        ResultData resultData = createDto(winningLottoCounts, rateOfReturn);
        OutputView.printResult(resultData);
    }

    private Integer[] countWinningLotto(final Lottos lottoInfo, final WinningNumbersData winningNumbersData, final BonusNumberData bonusNumberData) {
        List<Integer> winningNumbers = winningNumbersData.winningNumbers();
        List<Lotto> lottos = lottoInfo.getLottos();
        Integer[] winningLottoCounts = new Integer[WINNERS_COUNT.getValue()];
        Arrays.fill(winningLottoCounts, 0);

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            countSameNumber(winningNumbers, bonusNumberData, lottoNumbers, winningLottoCounts);
        }

        return winningLottoCounts;
    }

    private void countSameNumber(final List<Integer> winningNumbers, final BonusNumberData bonusNumberData, final List<Integer> lottoNumbers, final Integer[] winningLottoCounts) {
        int count = calculateCount(lottoNumbers, winningNumbers);
        if (count >= MIN_COUNT_FOR_PRIZE.getValue()) {
            int index = calculateIndex(count, bonusNumberData, lottoNumbers);
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
    private int calculateIndex(final Integer count, BonusNumberData bonusNumberData, final List<Integer> lottoNumbers) {
        int index = count - MIN_COUNT_FOR_PRIZE.getValue();
        if (count.equals(THIRD.getNumberCount())) {
            index = countBonusNumber(bonusNumberData, lottoNumbers);
        }
        if (count.equals(FIRST.getNumberCount())) {
            index++;
        }
        return index;
    }

    private int countBonusNumber(final BonusNumberData bonusNumberData, final List<Integer> lottoNumbers) {
        int bonusNumber = bonusNumberData.bonusNumber();
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

    private ResultData createDto(final Integer[] winningLottoCounts, final Double rateOfReturn) {
        return new ResultData(winningLottoCounts, rateOfReturn);
    }
}
