package lotto.domain.model;

import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private List<Lotto> lottos;
    private static final int RANGE_ZERO = 0;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos create(Integer lottoCount) {
        List<Lotto> lottos = IntStream.range(RANGE_ZERO, lottoCount)
                .mapToObj(count -> Lotto.create())
                .toList();

        return new Lottos(lottos);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }
}
