package nl.omoda.ecsearchservice.messaging.event;

import nl.omoda.ecsearchservice.messaging.dto.ProductOptionDto;
import nl.omoda.ecsearchservice.messaging.dto.StockMutationDto;

public class StockEvent {
    private ProductOptionDto productOption;
    private int amount;

    public StockEvent(StockMutationDto stockMutation) {
        this.productOption = stockMutation.getProductOption();
        this.amount = stockMutation.getAmount();
    }

    public ProductOptionDto getProductOption() {
        return this.productOption;
    }

    public int getAmount() {
        return this.amount;
    }

    public String toString() {
        return "{" +
            ", productOption='" + getProductOption() + "'" +
            ", amount='" + getAmount() + "'" +
            "}";
    }

}
