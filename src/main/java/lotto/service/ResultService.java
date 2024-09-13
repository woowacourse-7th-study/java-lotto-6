package lotto.service;

import lotto.dto.ResultDto;
import lotto.domain.model.Lotto;
import lotto.domain.model.Rank;
import lotto.domain.model.WinningLotto;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.constant.LottoConfig.PRICE_UNIT;

public class ResultService {
    private static final int PRICE_UNIT = 1000;

    // 당첨 통계를 진행하는 메서드
    public EnumMap<Rank, Integer> progressStatistics(List<Lotto> randomLottos, WinningLotto winningLotto) {
        EnumMap<Rank, Integer> rankStatistics = new EnumMap<>(Rank.class);

        randomLottos.forEach(randomLotto -> {
            int matchCount = MatchNumberService.getMatchNumber(winningLotto, randomLotto);
            boolean hasBonus = winningLotto.hasSameNumber(randomLotto);
            Rank rank = Rank.matchLottoRank(matchCount, hasBonus);
            rankStatistics.put(rank, rankStatistics.getOrDefault(rank, 0) + 1);
        });

        return rankStatistics;
    }


    // 랭크 상태를 문자열로 변환하는 메서드
    public String calculateTotalRankStatus(Map<Rank, Integer> rankStatistics) {
        List<ResultDto> resultDtoList = Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .sorted(Comparator.comparingInt(Rank::getRank).reversed())
                .map(rank -> new ResultDto(rank, rankStatistics.getOrDefault(rank, 0)))
                .toList();

        return resultDtoList.stream()
                .map(ResultDto::toRankStatusString)
                .collect(Collectors.joining("\n"));
    }

    // 수익률을 계산하는 메서드
    public float calculateProfitRate(int lottoCount, Map<Rank, Integer> rankStatistics) {
        int totalPrize = rankStatistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return ((float) totalPrize / (lottoCount * PRICE_UNIT) * 100);
    }
}
