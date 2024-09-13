package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constants.ErrorMessage.ENTER_THOUSAND;
import static lotto.constants.Number.UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchasePriceTest {
    @DisplayName("1000 단위의 입력이 아닌 경우 예외를 발생시킨다.")
    @Test
    void createPurchasePriceByNonThousand() {
        // given
        int price = UNIT.getValue() + 500;

        // when & then
        assertThatThrownBy(() -> new PurchasePrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ENTER_THOUSAND.toString());
    }

    @DisplayName("구매 가격을 1000 단위로 나누어 구매량을 구할 수 있다.")
    @Test
    void getQuantityByPurchasePrice() {
        // given
        int price = 8000;
        Integer expected = price / UNIT.getValue();
        PurchasePrice purchasePrice = new PurchasePrice(price);

        // when
        Integer real = purchasePrice.getQuantity();

        // then
        assertThat(real).isEqualTo(expected);
    }
}