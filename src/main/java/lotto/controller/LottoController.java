package lotto.controller;

import lotto.domain.dto.BonusNumberDto;
import lotto.domain.dto.InputDto;
import lotto.domain.dto.LottosDto;
import lotto.domain.dto.PurchasePriceDto;
import lotto.domain.dto.WinningNumbersDto;
import lotto.domain.model.Lottos;
import lotto.service.BonusNumberService;
import lotto.service.LottoService;
import lotto.service.PurchasePriceService;
import lotto.service.ResultService;
import lotto.service.WinningNumbersService;
import lotto.view.OutputView;

public class LottoController {
    private Lottos lottos;
    private PurchasePriceDto purchasePriceDto;
    private WinningNumbersDto winningNumbersDto;
    private BonusNumberDto bonusNumberDto;

    public void run() {
        inputPurchasePrice();
        printInformation();
        inputWinningNumbers();
        inputBonusNumber();
        printResult();
    }

    private void inputPurchasePrice() {
        final PurchasePriceService purchasePriceService = new PurchasePriceService();
        purchasePriceDto = purchasePriceService.inputPurchasePrice();
        issueLottos();
    }

    private void issueLottos() {
        final LottoService lottoService = new LottoService();
        Integer count = purchasePriceDto.quantity();
        lottos = lottoService.issueLottos(count);
    }

    private void printInformation() {
        LottosDto lottosDto = new LottosDto(lottos);
        OutputView.printQuantity(lottosDto);
        OutputView.printLottosNumbers(lottosDto);
    }

    private void inputWinningNumbers() {
        final WinningNumbersService winningNumbersService = new WinningNumbersService();
        winningNumbersDto = winningNumbersService.inputWinningNumbers();
    }

    private void inputBonusNumber() {
        BonusNumberService bonusNumberService = new BonusNumberService(winningNumbersDto.winningNumbers());
        bonusNumberDto = bonusNumberService.inputBonusNumber();
    }

    private void printResult() {
        final ResultService resultService = new ResultService();
        InputDto inputDto = new InputDto(lottos, winningNumbersDto, bonusNumberDto);
        resultService.printResult(inputDto);
    }
}
