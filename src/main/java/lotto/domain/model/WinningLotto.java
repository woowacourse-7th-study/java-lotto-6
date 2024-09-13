package lotto.domain.model;

import lotto.constant.exception.LottoException;

import java.util.List;

import static lotto.constant.exception.error.ErrorMessage.INVALID_DUPLICATION;

public class WinningLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber){
        validateDuplicatedNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicatedNumber(Lotto lotto, BonusNumber bonusNumber){ // lotto와 bonus 숫자의 중복을 검증
        if(lotto.hasSameNumber(bonusNumber)){
            throw new LottoException(INVALID_DUPLICATION);
        }
    }
    public boolean hasSameNumber(Lotto lotto) { // 당첨 번호 중 bonusNumber를 포함하는지 여부
        return lotto.getLottoNumbers().contains(bonusNumber.getNumber());
    }

    public List<Integer> getLottoNumbers() {
        return lotto.getLottoNumbers();
    }

}
