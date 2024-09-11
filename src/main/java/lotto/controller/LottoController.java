package lotto.controller;

import lotto.domain.dto.BonusNumberData;
import lotto.domain.dto.PurchasePriceData;
import lotto.domain.dto.WinningNumbersData;
import lotto.service.BonusNumberService;
import lotto.service.PurchasePriceService;
import lotto.service.WinningNumbersService;

public class LottoController {
    private final PurchasePriceService purchasePriceService;
    private final WinningNumbersService winningNumbersService;
    private BonusNumberService bonusNumberService;
    private PurchasePriceData purchasePriceData;
    private WinningNumbersData winningNumbersData;
    private BonusNumberData bonusNumberData;

    public LottoController() {
        this.purchasePriceService = new PurchasePriceService();
        this.winningNumbersService = new WinningNumbersService();
    }

    public void run() {
        inputPurchasePrice();
        inputWinningNumbers();
        inputBonusNumber();
    }

    private void inputPurchasePrice() {
        purchasePriceData = purchasePriceService.inputPurchasePrice();
    }

    private void inputWinningNumbers() {
        winningNumbersData = winningNumbersService.inputWinningNumbers();
    }

    private void inputBonusNumber() {
        bonusNumberService = new BonusNumberService(winningNumbersData.winningNumbers());
        bonusNumberData = bonusNumberService.inputBonusNumber();
    }
}
