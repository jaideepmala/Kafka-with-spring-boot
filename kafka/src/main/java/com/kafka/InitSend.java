package com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
class InitSend {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaSenderExample kafkaSenderExample;

    @Autowired
    private KafkaSenderWithMessageConverter messageConverterSender;

    @Value("${spring.kafka.kafka.topic-1}")
    private String topic1;

    @EventListener
    void initiateSendingMessage(ApplicationReadyEvent event) throws InterruptedException {
       // Thread.sleep(5000);
        LOG.info("---------------------------------");
        kafkaSenderExample.sendMessage("kafka message", topic1);
    }
}
