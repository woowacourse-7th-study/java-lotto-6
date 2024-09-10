package lotto.controller;

import lotto.constant.exception.LottoException;
import lotto.domain.dto.ConvertDto;
import lotto.view.InputView;
import lotto.view.outputView;

public class LottoGameController {
    public void run() {
        inputBuyLotto();
    }

    public void inputBuyLotto() {
        boolean isValid = true;  // 입력이 유효한지 여부를 저장
        while (isValid) {
            try {
                String userPrice = InputView.requestPrice();
                Integer lottoCount = ConvertDto.priceToTicket(userPrice);
                isValid = false;  // 유효한 입력이므로 루프 종료
            } catch (LottoException e) {
                outputView.printResult(e.getMessage());  // 에러 메시지 출력
            }
        }
    }
}
