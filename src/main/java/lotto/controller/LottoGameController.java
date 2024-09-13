package lotto.controller;

import lotto.constant.exception.LottoException;
import lotto.dto.RandomLottoDto;
import lotto.domain.model.*;
import lotto.service.ConvertingService;
import lotto.service.ResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;


public class LottoGameController {
    private Lotto inputWinningLotto;
    private Lottos randomLottos;
    private WinningLotto winningLotto;

    public void run() {
        runUntilNoException(inputBuyLottoRunnable());
        runUntilNoException(inputLottoNumberRunnable());
        runUntilNoException(inputBonusNumberRunnable());
        announceResult();
    }

    private void runUntilNoException(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (LottoException e) {
                OutputView.printResult(e.getMessage());  // 예외 메시지 출력
            }
        }
    }

    private Runnable inputBuyLottoRunnable() { // 로또 구입을 입력한다.
        return () -> {
            String userPrice = InputView.requestPrice();
            Integer lottoCount = ConvertingService.priceToTicket(userPrice);
            outputRandomLotto(lottoCount);
        };
    }

    private void outputRandomLotto(int lottoCount) { // 랜덤으로 생성한 로또 번호를 출력한다.
        OutputView.printLottoCount(lottoCount); //  로또 개수 출력
        randomLottos = Lottos.create(lottoCount); // 랜덤 로또 생성
        String outputLotto = RandomLottoDto.lottoToString(randomLottos.getLottos()); // toString
        OutputView.printResult(outputLotto);
    }

    private Runnable inputLottoNumberRunnable() { // 로또 당첨 번호를 입력 받는다
        return () -> {
            String inputLotto = InputView.requestWinningLotto();  // 로또 당첨 번호 입력 받기
            inputWinningLotto = Lotto.create(inputLotto);  // 입력된 값을 Lotto 객체로 변환
        };
    }

    private Runnable inputBonusNumberRunnable() { // 보너스 번호를 입력 받는다.
        return () -> {
            String inputBonus = InputView.requestBonusLotto();  // 보너스 번호 입력 받기
            Integer bonus = ConvertingService.stringToInteger(inputBonus);
            BonusNumber bonusNumber = new BonusNumber(bonus);
            winningLotto = new WinningLotto(inputWinningLotto, bonusNumber);
        };
    }

    private void announceResult() { // 최종 결과 출력
        OutputView.printHeaderNotice();
        progressStatistics();
    }

    private void progressStatistics() {
        final ResultService resultService = new ResultService();

        Map<Rank, Integer> rankStatistics = resultService.progressStatistics(randomLottos.getLottos(), winningLotto);
        String totalRankStatus = resultService.calculateTotalRankStatus(rankStatistics);
        OutputView.printResult(totalRankStatus);
        float profitRate = resultService.calculateProfitRate(randomLottos.size(), rankStatistics);
        OutputView.printTotalRate(profitRate);
    }
}
