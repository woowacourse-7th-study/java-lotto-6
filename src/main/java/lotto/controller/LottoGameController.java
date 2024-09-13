package lotto.controller;

import lotto.constant.exception.LottoException;
import lotto.domain.dto.ConvertDto;
import lotto.domain.dto.RandomLottoDto;
import lotto.domain.dto.ResultDto;
import lotto.domain.model.*;
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

    Map<Rank, Integer> rankStatistics;

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

    private void announceResult() { // 당첨 통계를 출력한다.
        OutputView.printHeaderNotice();
        progressStatistics();
        String totalRankStatus = calculateTotalRankStatus();  // 각 Rank의 상태를 하나의 문자열로 합침
        OutputView.printResult(totalRankStatus);  // 최종 결과 출력
        OutputView.printTotalRate(calculateProfitRate(lottoCount * 1000));
    }

    private void progressStatistics() { // 통계 진행
        rankStatistics = new HashMap<>();

        randomLottos.getLottos().forEach(randomLotto -> {
            int matchCount = MatchNumberService.getMatchNumber(winningLotto, randomLotto);  // 일치하는 숫자 개수 계산
            boolean hasBonus = winningLotto.hasSameNumber(randomLotto);  // 보너스 번호 일치 여부 확인
            Rank rank = Rank.matchLottoRank(matchCount, hasBonus);  // Rank 결정
            rankStatistics.put(rank, rankStatistics.getOrDefault(rank, 0) + 1);  // Rank에 해당하는 카운트 증가
        });
    }

    private String calculateTotalRankStatus() {
        List<ResultDto> resultDtoList = Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)  // Rank.NONE은 제외
                .sorted(Comparator.comparingInt(Rank::getRank).reversed())  // Rank의 순서 내림차순 정렬
                .map(rank -> new ResultDto(rank, rankStatistics.getOrDefault(rank, 0)))  // ResultDto로 변환
                .toList();

        // ResultDto 리스트를 순회하며 각 랭크 상태를 문자열로 변환하고, 개행 문자로 연결
        return resultDtoList.stream()
                .map(ResultDto::toRankStatusString)  // 각 DTO의 상태를 문자열로 변환
                .collect(Collectors.joining("\n"));
    }

    private float calculateProfitRate(int totalPurchaseAmount) {
        // 총 당첨 금액 계산
        int totalPrize = rankStatistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())  // 각 Rank의 상금 * 당첨 횟수
                .sum();

        return ((float) totalPrize / totalPurchaseAmount) * 100;
    }


}
