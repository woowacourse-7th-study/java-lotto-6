package lotto.dto;

import lotto.model.Lotto;
import lotto.model.Lottos;

import java.util.List;

public record LottosDto(List<Lotto> lottos) {
    public LottosDto(Lottos lottos) {
        this(lottos.getLottos());
    }

    public Integer size() {
        return lottos.size();
    }
}
