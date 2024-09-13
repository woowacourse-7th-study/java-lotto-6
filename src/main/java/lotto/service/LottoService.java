package lotto.service;

import static lotto.constant.LottoConfig.PRICE_UNIT;

public class LottoService {
    private Integer lottoCount;

    public void setLottoCount(Integer lottoCount) {
        this.lottoCount = lottoCount;
    }

    public Integer getLottoCount() {
        return this.lottoCount;
    }

    public Integer getUnitPrice() {
        return PRICE_UNIT.getValue();  // UNIT_PRICE를 반환하는 메서드
    }

    public Integer getLottoPrice(){
        return this.lottoCount * PRICE_UNIT.getValue();
    }
}
