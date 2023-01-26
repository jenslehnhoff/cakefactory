package cloud.knut.cakefactory.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BasketItem {

    final private CakeItem cake;
    final private int qty;

    BigDecimal getTotalPrice() {
        return this.cake.getPrice().multiply(BigDecimal.valueOf(qty));
    }
}
