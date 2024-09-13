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
    public void printResult(InputData inputData) {
        OutputView.printResultHeader();
        Integer[] winningLottoCounts = countWinningLotto(inputData);

        Lottos lottos = inputData.lottos();
        Double rateOfReturn = calculateRateOfReturn(lottos, winningLottoCounts);
        ResultData resultData = createDto(winningLottoCounts, rateOfReturn);
        OutputView.printResult(resultData);
    }

    private Integer[] countWinningLotto(InputData inputData) {
        Lottos lottosInfo = inputData.lottos();
        WinningNumbersData winningNumbersData = inputData.winningNumbersData();
        BonusNumberData bonusNumberData = inputData.bonusNumberData();

        List<Integer> winningNumbers = winningNumbersData.winningNumbers();
        List<Lotto> lottos = lottosInfo.getLottos();

        Integer[] winningLottoCounts = new Integer[WINNERS_COUNT.getValue()];
        Arrays.fill(winningLottoCounts, 0);

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            CountData countData = new CountData(lottoNumbers, winningNumbers, bonusNumberData, winningLottoCounts);
            countSameNumber(countData);
        }

        return winningLottoCounts;
    }

    private void countSameNumber(CountData countData) {
        List<Integer> lottoNumbers = countData.lottoNumbers();
        List<Integer> winningNumbers = countData.winningNumbers();
        BonusNumberData bonusNumberData = countData.bonusNumberData();
        Integer[] winningLottoCounts = countData.winningLottoCounts();

        int count = calculateCount(lottoNumbers, winningNumbers);
        if (count >= MIN_COUNT_FOR_PRIZE.getValue()) {
            int index = calculateIndex(lottoNumbers, bonusNumberData, count);
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
    private int calculateIndex(final List<Integer> lottoNumbers, BonusNumberData bonusNumberData, final Integer count) {
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
