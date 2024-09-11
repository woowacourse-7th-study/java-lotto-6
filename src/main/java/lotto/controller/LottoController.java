package lotto.controller;

import lotto.domain.dto.BonusNumberData;
import lotto.domain.dto.PurchasePriceData;
import lotto.domain.dto.WinningNumbersData;
import lotto.domain.model.Lottos;
import lotto.service.BonusNumberService;
import lotto.service.LottoService;
import lotto.service.PurchasePriceService;
import lotto.service.WinningNumbersService;

public class LottoController {
    private final PurchasePriceService purchasePriceService;
    private final LottoService lottoService;
    private final WinningNumbersService winningNumbersService;

    private BonusNumberService bonusNumberService;
    private Lottos lottos;
    private PurchasePriceData purchasePriceData;
    private WinningNumbersData winningNumbersData;
    private BonusNumberData bonusNumberData;

    public LottoController() {
        this.purchasePriceService = new PurchasePriceService();
        this.winningNumbersService = new WinningNumbersService();
        this.lottoService = new LottoService();
    }

    public void run() {
        inputPurchasePrice();
        issueLottos();
        inputWinningNumbers();
        inputBonusNumber();
    }

    private void inputPurchasePrice() {
        purchasePriceData = purchasePriceService.inputPurchasePrice();
    }

    private void issueLottos() {
        Integer count = purchasePriceData.quantity();
        lottos = lottoService.issueLottos(count);
    }

    private void inputWinningNumbers() {
        winningNumbersData = winningNumbersService.inputWinningNumbers();
    }

    private void inputBonusNumber() {
        bonusNumberService = new BonusNumberService(winningNumbersData.winningNumbers());
        bonusNumberData = bonusNumberService.inputBonusNumber();
    }
}
