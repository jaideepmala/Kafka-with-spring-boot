package com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;



@Component
class KafkaListenerExample {

    Logger LOG = LoggerFactory.getLogger(KafkaListenerExample.class);

    @KafkaListener(topics = "topic1")
    void listener(String data) {
        LOG.info("listening: "+data);
    }

    @KafkaListener(
            topics = "topic1",
            groupId = "myGroup")
    void commonListenerForMultipleTopics(String message) {
        LOG.debug("MultipleTopicListener - {}", message);
    }
}
