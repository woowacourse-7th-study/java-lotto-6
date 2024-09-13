package lotto.service;

import lotto.factory.LottoFactory;
import lotto.model.Lotto;
import lotto.model.Lottos;


public class LottoService {
    public Lottos issueLottos(final Integer count) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < count; i++) {
            Lotto lotto = LottoFactory.issueLotto();
            lottos.addLotto(lotto);
        }
        return lottos;
    }
}
