package lotto.domain.dto;

import lotto.domain.model.Rank;

public class ResultDto {
    private final Rank rank;
    private final int count;

    public ResultDto(Rank rank, int count) {
        this.rank = rank;
        this.count = count;
    }


    public String toRankStatusString() { // 랭크 상태를 문자열로 변환하는 메서드
        StringBuilder status = new StringBuilder();

        // 일치하는 숫자 개수 추가
        status.append(rank.getRank()).append("개 일치");

        // 보너스 번호가 있는 경우 처리
        if (rank.getHasBonus()) {
            status.append(", 보너스 볼 일치");
        }

        // 상금 및 개수 추가
        status.append(String.format(" (%,d원)", rank.getPrize()));
        status.append(String.format(" - %d개", count));

        return status.toString();
    }
}
