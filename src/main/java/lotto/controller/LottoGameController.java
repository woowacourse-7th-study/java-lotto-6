package lotto.controller;

import lotto.constant.exception.LottoException;
import lotto.domain.dto.ConvertDto;
import lotto.domain.dto.RandomLottoDto;
import lotto.domain.dto.ResultDto;
import lotto.domain.model.*;
import lotto.service.ResultService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.service.MatchNumberService;

import java.util.*;
import java.util.stream.Collectors;


public class LottoGameController {
    private Integer lottoCount;
    private Lotto inputWinningLotto;
    private Lottos randomLottos;
    private WinningLotto winningLotto;

    public void run() {
        inputBuyLotto();
        outputRandomLotto();
        inputLottoNumber();
        inputBonusNumber();
        announceResult();
    }

    private void inputBuyLotto() { // 로또 구입을 입력한다.
        boolean isValid = true;  // 입력이 유효한지 여부를 저장
        while (isValid) {
            try {
                String userPrice = InputView.requestPrice();
                lottoCount = ConvertDto.priceToTicket(userPrice);
                isValid = false;  // 유효한 입력이므로 루프 종료
            } catch (LottoException e) {
                OutputView.printResult(e.getMessage());  // 에러 메시지 출력
            }
        }
    }

    private void outputRandomLotto() { // 랜덤으로 생성한 로또 번호를 출력한다.
        OutputView.printLottoCount(lottoCount); //  로또 개수 출력
        randomLottos = Lottos.create(lottoCount); // 랜덤 로또 생성
        String outputLotto = RandomLottoDto.lottoToString(randomLottos.getLottos()); // toString
        OutputView.printResult(outputLotto);
    }

    private void inputLottoNumber() { // 로또 당첨 번호를 입력 받는다.
        boolean isValid = true;
        while (isValid) {
            try {
                String inputLotto = InputView.requestWinningLotto(); // 로또 당첨 번호 입력 받기.
                inputWinningLotto = Lotto.create(inputLotto);
                isValid = false;
            } catch (LottoException e) {
                OutputView.printResult(e.getMessage());  // 에러 메시지 출력
            }
        }
    }

    private void inputBonusNumber() { // 보너스 번호를 입력 받는다.
        boolean isValid = true;
        while (isValid) {
            try {
                String inputBonus = InputView.requestBonusLotto(); // 보너스 번호 입력 받기.
                Integer bonus = ConvertDto.stringToInteger(inputBonus);
                BonusNumber bonusNumber = new BonusNumber(bonus);
                winningLotto = new WinningLotto(inputWinningLotto, bonusNumber);
                isValid = false;
            } catch (LottoException e) {
                OutputView.printResult(e.getMessage());
            }
        }
    }

    private void announceResult() { // 최종 결과 출력
        final ResultService lottoService = new ResultService();
        OutputView.printHeaderNotice();
        progressStatistics();
    }

    private void progressStatistics() {
        final ResultService lottoService = new ResultService();

        Map<Rank, Integer> rankStatistics = lottoService.progressStatistics(randomLottos.getLottos(), winningLotto);
        String totalRankStatus = lottoService.calculateTotalRankStatus(rankStatistics);
        OutputView.printResult(totalRankStatus);
        float profitRate = lottoService.calculateProfitRate(lottoCount * 1000, rankStatistics);
        OutputView.printTotalRate(profitRate);
    }
}
