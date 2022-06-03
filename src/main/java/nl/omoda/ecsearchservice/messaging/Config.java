package nl.omoda.ecsearchservice.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.AckMode;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;

@Configuration
public class Config {
    private final Logger logger = LoggerFactory.getLogger(Config.class);

    @Bean
    public PubSubInboundChannelAdapter messageProductChannelAdapter(
            @Qualifier(Channels.PRODUCT_INPUT) MessageChannel inputChannel,
            PubSubTemplate pubSubTemplate
    ) {
        this.logger.info("Received a product message!");

        return this.createMessageChannelAdapter(inputChannel, Channels.PRODUCT_INPUT, pubSubTemplate);
    }

    @Bean
    public PubSubInboundChannelAdapter messageProductOptionChannelAdapter(
            @Qualifier(Channels.PRODUCT_OPTION_INPUT) MessageChannel inputChannel,
            PubSubTemplate pubSubTemplate
    ) {
        this.logger.info("Received a product option message!");

        return this.createMessageChannelAdapter(inputChannel, Channels.PRODUCT_OPTION_INPUT, pubSubTemplate);
    }

    @Bean
    public PubSubInboundChannelAdapter messageStockChannelAdapter(
            @Qualifier(Channels.PRODUCT_OPTION_INPUT) MessageChannel inputChannel,
            PubSubTemplate pubSubTemplate
    ) {
        this.logger.info("Received a stock message!");

        return this.createMessageChannelAdapter(inputChannel, Channels.STOCK_INPUT, pubSubTemplate);
    }

    private PubSubInboundChannelAdapter createMessageChannelAdapter(
            MessageChannel inputChannel,
            String channel,
            PubSubTemplate pubSubTemplate
    ) {
        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, channel);
        adapter.setOutputChannel(inputChannel);
        adapter.setAckMode(AckMode.MANUAL);

        return adapter;
    }
}
