package lotto.controller;

import lotto.domain.dto.*;
import lotto.domain.model.Lottos;
import lotto.service.*;
import lotto.view.OutputView;

public class LottoController {
    private final PurchasePriceService purchasePriceService;
    private final LottoService lottoService;
    private final WinningNumbersService winningNumbersService;
    private final ResultService resultService;

    private BonusNumberService bonusNumberService;
    private Lottos lottos;
    private PurchasePriceData purchasePriceData;
    private WinningNumbersData winningNumbersData;
    private BonusNumberData bonusNumberData;

    public LottoController() {
        this.purchasePriceService = new PurchasePriceService();
        this.winningNumbersService = new WinningNumbersService();
        this.lottoService = new LottoService();
        this.resultService = new ResultService();
    }

    public void run() {
        inputPurchasePrice();
        printInformation();
        inputWinningNumbers();
        inputBonusNumber();
        printResult();
    }

    private void inputPurchasePrice() {
        purchasePriceData = purchasePriceService.inputPurchasePrice();
        issueLottos();
    }

    private void issueLottos() {
        Integer count = purchasePriceData.quantity();
        lottos = lottoService.issueLottos(count);
    }

    private void printInformation() {
        LottosData lottosData = new LottosData(lottos);
        OutputView.printQuantity(lottosData);
        OutputView.printLottosNumbers(lottosData);
    }

    private void inputWinningNumbers() {
        winningNumbersData = winningNumbersService.inputWinningNumbers();
    }

    private void inputBonusNumber() {
        bonusNumberService = new BonusNumberService(winningNumbersData.winningNumbers());
        bonusNumberData = bonusNumberService.inputBonusNumber();
    }

    private void printResult() {
        InputData inputData = new InputData(lottos, winningNumbersData, bonusNumberData);
        resultService.printResult(inputData);
    }
}
