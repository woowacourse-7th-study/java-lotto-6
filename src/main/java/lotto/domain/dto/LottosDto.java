package lotto.domain.dto;

import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;

import java.util.List;

public record LottosDto(List<Lotto> lottos) {
    public LottosDto(Lottos lottos) {
        this(lottos.getLottos());
    }

    public Integer size() {
        return lottos.size();
    }
}
