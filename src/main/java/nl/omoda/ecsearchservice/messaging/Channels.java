package nl.omoda.ecsearchservice.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface Channels {
    String PRODUCT_INPUT = "product.ec-search-service";
    String PRODUCT_OPTION_INPUT = "product-option.ec-search-service";
    String STOCK_INPUT = "product.ec-search-service";

    @Input(PRODUCT_INPUT)
    MessageChannel incomingProduct();

    @Input(PRODUCT_OPTION_INPUT)
    MessageChannel incomingProductOption();

    @Input(STOCK_INPUT)
    MessageChannel incomingStock();
}
