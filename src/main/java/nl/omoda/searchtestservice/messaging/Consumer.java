package nl.omoda.ecsearchservice.messaging;

import com.google.cloud.spring.pubsub.support.BasicAcknowledgeablePubsubMessage;
import com.google.cloud.spring.pubsub.support.GcpPubSubHeaders;

import nl.omoda.ecsearchservice.messaging.dto.ProductDto;
import nl.omoda.ecsearchservice.messaging.dto.ProductOptionDto;
import nl.omoda.ecsearchservice.messaging.event.ProductCrudEvent;
import nl.omoda.ecsearchservice.messaging.event.ProductOptionCrudEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @ServiceActivator(inputChannel = Channels.PRODUCT_INPUT)
    public void handleProductMessage(Message<ProductCrudEvent> message)
            throws Exception {
        try {
            ProductCrudEvent event = message.getPayload();
            ProductDto product = event.getPayload();
            
            this.logger.info(String.format("Received product: '%s'", product.toString()));
            this.ack(message);
        } catch (Exception e) {
            this.logger.error("Failed to handle product message!");

            throw e;
        }
    }

    @ServiceActivator(inputChannel = Channels.PRODUCT_OPTION_INPUT)
    public void handleProductOptionMessage(Message<ProductOptionCrudEvent> message) throws Exception {
        try {
            ProductOptionCrudEvent event = message.getPayload();
            ProductOptionDto productOption = event.getPayload();

            this.logger.info(String.format("Received product option: '%s'", productOption.toString()));
            this.ack(message);
        } catch (Exception e) {
            this.logger.error("Failed to handle product option message!");

            throw e;
        }
    }

    private void ack(Message<?> message) {
        BasicAcknowledgeablePubsubMessage originalMessage = message.getHeaders().get(GcpPubSubHeaders.ORIGINAL_MESSAGE,
                BasicAcknowledgeablePubsubMessage.class);
        if (originalMessage != null) {
            originalMessage.ack();
        }
    }
}
