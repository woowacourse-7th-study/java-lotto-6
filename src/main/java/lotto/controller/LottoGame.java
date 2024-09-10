package lotto.controller;

import lotto.domain.dto.ConvertDto;
import lotto.view.InputView;
import lotto.view.outputView;

public class LottoGame {
    public void run() {

        try{
            inputBuyLotto();
        }catch (IllegalArgumentException e){
            outputView.printResult(e.getMessage());
        };
    }

    public void inputBuyLotto(){
        String userPrice = InputView.requestPrice();
        Integer lottoCount = ConvertDto.priceToTicket(userPrice); // lotto의 개수
    }
}
