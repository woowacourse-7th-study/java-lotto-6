package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.factory.LottoFactory;

public class LottoService {

    private final LottoFactory lottoFactory;

    public LottoService() {
        lottoFactory = new LottoFactory();
    }

    public Lottos issueLottos(final Integer count) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < count; i++) {
            Lotto lotto = lottoFactory.issueLotto();
            lottos.addLotto(lotto);
        }
        return lottos;
    }
}
