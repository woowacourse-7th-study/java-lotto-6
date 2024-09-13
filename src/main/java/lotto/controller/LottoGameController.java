package lotto.controller;

import lotto.constant.exception.LottoException;
import lotto.domain.dto.ConvertDto;
import lotto.domain.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.service.MatchNumberService;

import java.util.HashMap;
import java.util.Map;


public class LottoGameController {
    Integer lottoCount;
    Lotto inputWinningLotto;
    Lottos randomLottos;
    WinningLotto winningLotto;

    public void run() {
        inputBuyLotto();
        outputRandomLotto();
        inputLottoNumber();
        inputBonusNumber();
        announceResult();
    }

    public void inputBuyLotto() { // 로또 구입을 입력한다.
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

    public void outputRandomLotto() { // 랜덤으로 생성한 로또 번호를 출력한다.
        OutputView.printLottoCount(lottoCount); //  로또 개수 출력
        randomLottos = Lottos.create(lottoCount); // 랜덤 로또 생성
        OutputView.printRandomLottos(randomLottos.getLottos());
    }

    public void inputLottoNumber(){ // 로또 당첨 번호를 입력 받는다.
        boolean isValid = true;
        while(isValid){
            try{
                String inputLotto = InputView.requestWinningLotto(); // 로또 당첨 번호 입력 받기.
                inputWinningLotto = Lotto.create(inputLotto);
                isValid = false;
            }catch (LottoException e) {
                OutputView.printResult(e.getMessage());  // 에러 메시지 출력
            }
        }
    }

    public void inputBonusNumber(){ // 보너스 번호를 입력 받는다.
        boolean isValid = true;
        while(isValid){
            try{
                String inputBonus = InputView.requestBonusLotto(); // 보너스 번호 입력 받기.
                Integer bonus = ConvertDto.stringToInteger(inputBonus);
                BonusNumber bonusNumber = new BonusNumber(bonus);
                winningLotto = new WinningLotto(inputWinningLotto, bonusNumber);
                isValid = false;
            }catch(LottoException e){
                OutputView.printResult(e.getMessage());
            }
        }
    }

    public void announceResult(){ // 당첨 통계를 출력한다.
        OutputView.printHeaderNotice();
        progressStatistics();
    }

    private void progressStatistics() { // 통계 진행
        Map<Rank, Integer> rankStatistics = new HashMap<>();

        randomLottos.getLottos().forEach(randomLotto -> {
            int matchCount = MatchNumberService.getMatchNumber(winningLotto, randomLotto); // 일치하는 숫자 개수 계산
            boolean hasBonus = winningLotto.hasSameNumber(randomLotto); // 보너스 번호가 일치하는지 확인

            Rank rank = Rank.matchLottoRank(matchCount, hasBonus); // 등수 계산
            rankStatistics.put(rank, rankStatistics.getOrDefault(rank, 0) + 1); // 통계 업데이트
        });

        printStatistics(rankStatistics); // 통계 출력
    }

    private void printStatistics(Map<Rank, Integer> rankStatistics) {
        OutputView.printRankResult(Rank.FIFTH, rankStatistics.getOrDefault(Rank.FIFTH, 0));
        OutputView.printRankResult(Rank.FIRTH, rankStatistics.getOrDefault(Rank.FIRTH, 0));
        OutputView.printRankResult(Rank.THIRD, rankStatistics.getOrDefault(Rank.THIRD, 0));
        OutputView.printRankResult(Rank.SECOND, rankStatistics.getOrDefault(Rank.SECOND, 0));
        OutputView.printRankResult(Rank.FIRST, rankStatistics.getOrDefault(Rank.FIRST, 0));
    }


}
