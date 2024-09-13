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
    private PurchasePriceDto purchasePriceDto;
    private WinningNumbersDto winningNumbersDto;
    private BonusNumberDto bonusNumberDto;

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
        purchasePriceDto = purchasePriceService.inputPurchasePrice();
        issueLottos();
    }

    private void issueLottos() {
        Integer count = purchasePriceDto.quantity();
        lottos = lottoService.issueLottos(count);
    }

    private void printInformation() {
        LottosDto lottosDto = new LottosDto(lottos);
        OutputView.printQuantity(lottosDto);
        OutputView.printLottosNumbers(lottosDto);
    }

    private void inputWinningNumbers() {
        winningNumbersDto = winningNumbersService.inputWinningNumbers();
    }

    private void inputBonusNumber() {
        bonusNumberService = new BonusNumberService(winningNumbersDto.winningNumbers());
        bonusNumberDto = bonusNumberService.inputBonusNumber();
    }

    private void printResult() {
        InputDto inputDto = new InputDto(lottos, winningNumbersDto, bonusNumberDto);
        resultService.printResult(inputDto);
    }
}
