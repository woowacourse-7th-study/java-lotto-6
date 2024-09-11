package lotto.service;

import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;
import lotto.factory.LottoFactory;

public class LottoService {

    private LottoFactory lottoFactory;

    public LottoService() {
        lottoFactory = new LottoFactory();
    }

    public Lottos issueLottos(Integer count) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < count; i++) {
            Lotto lotto = lottoFactory.issueLotto();
            lottos.addLotto(lotto);
        }
        return lottos;
    }
}
