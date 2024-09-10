package lotto.constant.exception;

import lotto.constant.exception.error.ErrorMessage;

public class LottoException extends IllegalArgumentException {
    public LottoException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
