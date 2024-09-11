package lotto.controller;

import lotto.constant.exception.LottoException;
import lotto.domain.dto.ConvertDto;
import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;
import lotto.domain.model.WinningLotto;
import lotto.domain.randomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoGameController {
    Integer lottoCount;
    Lotto inputWinningLotto;

    public void run() {
        inputBuyLotto();
        outputRandomLotto();
        inputLottoNumber();
        inputBonusNumber();
        announceResult();
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

    public void outputRandomLotto() { // 랜덤으로 생성한 로또 번호를 출력한다.
        OutputView.printLottoCount(lottoCount); //  로또 개수 출력
        Lottos randomLottos = Lottos.create(lottoCount); // 랜덤 로또 생성
        OutputView.printRandomLottos(randomLottos.getLottos());
    }

    public void inputLottoNumber(){ // 로또 당첨 번호를 입력 받는다.
        boolean isValid = true;
        while(isValid){
            try{
                String inputLotto = InputView.requestWinningLotto(); // 로또 당첨 번호 입력 받기.
                inputWinningLotto = Lotto.create(inputLotto);
                isValid = false;
            }catch (LottoException e) {
                OutputView.printResult(e.getMessage());  // 에러 메시지 출력
            }
        }
    }

    public void inputBonusNumber(){ // 보너스 번호를 입력 받는다.
        boolean isValid = true;
        while(isValid){
            try{
                String inputBonus = InputView.requestBonusLotto(); // 보너스 번호 입력 받기.
                Integer bonus = ConvertDto.stringToInteger(inputBonus);
                BonusNumber bonusNumber = new BonusNumber(bonus);
                WinningLotto winningLotto = new WinningLotto(inputWinningLotto, bonusNumber);
                isValid = false;
            }catch(LottoException e){
                OutputView.printResult(e.getMessage());
            }
        }
    }

    public void announceResult(){ // 당첨 통계를 출력한다.
        OutputView.printHeaderNotice();
    }

}
