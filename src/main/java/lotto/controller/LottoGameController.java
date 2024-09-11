package lotto.controller;

import lotto.constant.exception.LottoException;
import lotto.domain.dto.ConvertDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    Integer lottoCount;

    public void run() {
        inputBuyLotto();
        outputLotto();
    }

    public void inputBuyLotto() { // 로또 구입을 입력한다.
        boolean isValid = true;  // 입력이 유효한지 여부를 저장
        while (isValid) {
            try {
                String userPrice = InputView.requestPrice();
                lottoCount = ConvertDto.priceToTicket(userPrice);
                isValid = false;  // 유효한 입력이므로 루프 종료
            } catch (LottoException e) {
                OutputView.printResult(e.getMessage());  // 에러 메시지 출력
            }
        }
    }

    public void outputLotto() {
        OutputView.printLottoCount(lottoCount); //  로또 개수 출력

    }

}
