package lotto.domain.dto;

import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;

import java.util.List;

public record LottosData(List<Lotto> lottos) {
    public LottosData(Lottos lottos) {
        this(lottos.getLottos());
    }

    public Integer size() {
        return lottos.size();
    }
}
