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

public class ResultService {
    public void printResult(Lottos lottos, WinningNumbersData winningNumbersData, BonusNumberData bonusNumberData) {
        OutputView.printResultHeader();
        Integer[] winningLottoCounts = countWinningLotto(lottos, winningNumbersData, bonusNumberData);
        Double rateOfReturn = calculateRateOfReturn(lottos, winningLottoCounts);
        ResultData resultData = createDto(winningLottoCounts, rateOfReturn);
        OutputView.printResult(resultData);
    }

    private Integer[] countWinningLotto(Lottos lottoInfo, WinningNumbersData winningNumbersData, BonusNumberData bonusNumberData) {
        List<Integer> winningNumbers = winningNumbersData.winningNumbers();
        List<Lotto> lottos = lottoInfo.getLottos();
        Integer[] winningLottoCounts = new Integer[5];
        Arrays.fill(winningLottoCounts, 0);

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            countSameNumber(winningNumbers, bonusNumberData, lottoNumbers, winningLottoCounts);
        }
        return winningLottoCounts;
    }

    private void countSameNumber(List<Integer> winningNumbers, BonusNumberData bonusNumberData, List<Integer> lottoNumbers, Integer[] winningLottoCounts) {
        int count = calculateCount(lottoNumbers, winningNumbers);
        if (count > 2) {
            int index = calculateIndex(count, bonusNumberData, lottoNumbers);
            winningLottoCounts[index]++;
        }
    }

    private int calculateCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    /*
      count          index
        3         ->   0
        4         ->   1
        5         ->   2
        5 + bonus ->   3
        6         ->   4
     */
    private int calculateIndex(int count, BonusNumberData bonusNumberData, List<Integer> lottoNumbers) {
        int index = count - 3;
        if (count == 5) {
            index = countBonusNumber(bonusNumberData, lottoNumbers);
        }
        if (count == 6) {
            index++;
        }
        return index;
    }

    private int countBonusNumber(BonusNumberData bonusNumberData, List<Integer> lottoNumbers) {
        int bonusNumber = bonusNumberData.bonusNumber();
        if (lottoNumbers.contains(bonusNumber)) {
            return 3;
        }
        return 2;
    }

    private Double calculateRateOfReturn(Lottos lottos, Integer[] winningLottoCounts) {
        Integer size = lottos.size();
        Integer purchaseAmount = size * Number.UNIT.getValue();
        Long profitAmount = calculateProfitAmount(winningLottoCounts);
        Double rateOfReturn = (double) (profitAmount - purchaseAmount) / purchaseAmount * 100;
        return rateOfReturn;
    }

    private Long calculateProfitAmount(Integer[] winningLottoCounts) {
        long profitAmount = 0;
        for (Profit profit : Profit.values()) {
            int index = profit.ordinal();
            profitAmount += winningLottoCounts[index] * profit.getProfit();
        }
        return profitAmount;
    }

    private ResultData createDto(Integer[] winningLottoCounts, Double rateOfReturn) {
        return new ResultData(winningLottoCounts, rateOfReturn);
    }
}
